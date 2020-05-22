import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.provider.FormEncodingProvider;

@Provider
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class StuffResponseReader  implements MessageBodyReader<StuffResponse> {

    private FormEncodingProvider<Form> formProvider = new FormEncodingProvider<>();

    private static final String PROP_ERROR_CODE                 = "errorCode";
    private static final String PROP_ERROR_DESCRIPTION          = "errorMessage";
    ...

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type.isAssignableFrom(StuffResponse.class);
    }

    @Override
    public StuffResponse readFrom(Class<StuffResponse> type, Type genericType, Annotation[] annotations,
            MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        Form    form    = formProvider.readFrom(Form.class, Form.class, annotations, mediaType, httpHeaders, entityStream);
        MultivaluedMap<String, String> data = form.asMap();
        return new StuffResponse().
                errorCode(data.getFirst(PROP_ERROR_CODE)).
                errorDescription(data.getFirst(PROP_ERROR_DESCRIPTION)).
                ...;
    }
}