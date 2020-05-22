import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import javax.xml.transform.stream.StreamSource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import javax.xml.bind.*;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MOXyJSONProvider implements
    MessageBodyReader<Object>, MessageBodyWriter<Object>{

    @Context
    protected Providers providers;

    public boolean isReadable(Class<?> type, Type genericType,
        Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    public Object readFrom(Class<Object> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
            try {
                Class<?> domainClass = getDomainClass(genericType);
                Unmarshaller u = getJAXBContext(domainClass, mediaType).createUnmarshaller();
                u.setProperty("eclipselink.media-type", mediaType.toString());
                u.setProperty("eclipselink.json.include-root", false);
                return u.unmarshal(new StreamSource(entityStream), domainClass).getValue();
            } catch(JAXBException jaxbException) {
                throw new WebApplicationException(jaxbException);
            }
    }

    public boolean isWriteable(Class<?> type, Type genericType,
        Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    public void writeTo(Object object, Class<?> type, Type genericType,
        Annotation[] annotations, MediaType mediaType,
        MultivaluedMap<String, Object> httpHeaders,
        OutputStream entityStream) throws IOException,
        WebApplicationException {
        try {
            Class<?> domainClass = getDomainClass(genericType);
            Marshaller m = getJAXBContext(domainClass, mediaType).createMarshaller();
            m.setProperty("eclipselink.media-type", mediaType.toString());
            m.setProperty("eclipselink.json.include-root", false);
            m.marshal(object, entityStream);
        } catch(JAXBException jaxbException) {
            throw new WebApplicationException(jaxbException);
        }
    }

    public long getSize(Object t, Class<?> type, Type genericType,
        Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    private JAXBContext getJAXBContext(Class<?> type, MediaType mediaType)
        throws JAXBException {
        ContextResolver<JAXBContext> resolver
            = providers.getContextResolver(JAXBContext.class, mediaType);
        JAXBContext jaxbContext;
        if(null == resolver || null == (jaxbContext = resolver.getContext(type))) {
            return JAXBContextFactory.createContext(new Class[] {type}, null); 
        } else {
            return jaxbContext;
        }
    }

    private Class<?> getDomainClass(Type genericType) {
        if(genericType instanceof Class) {
            return (Class<?>) genericType;
        } else if(genericType instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) genericType).getActualTypeArguments()[0];
        } else {
            return null;
        }
    }

}