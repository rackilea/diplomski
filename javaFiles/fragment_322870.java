import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Scanner;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

import common.SerializeUtil;

@Provider
public class CustomMessageBodyReader implements MessageBodyReader<Child> {

    @Context
    private Providers providers;

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // TODO Auto-generated method stub
        return Parent.class.isAssignableFrom(type); 
    }

    @Override
    public Child readFrom(Class<Child> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        String entity = toString(entityStream);
        Child child = SerializeUtil.fromString(entity, Child.class);
        return child;
    }

    public static String toString(InputStream inputStream) {
        return new Scanner(inputStream, "UTF-8")
                .useDelimiter("\\A").next();
    }

}