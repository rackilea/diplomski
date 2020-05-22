import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import protobuf.example.WidgetsProtoc.Widget;
import protobuf.example.WidgetsProtoc.WidgetList;

@Provider
@Produces("application/protobuf")
@Consumes("application/protobuf")
public class WidgetProtocMessageBodyProvder 
                   implements MessageBodyReader, MessageBodyWriter {

    @Override
    public boolean isReadable(Class type, Type type1, 
            Annotation[] antns, MediaType mt) {
        return Widget.class.isAssignableFrom(type) 
                || WidgetList.class.isAssignableFrom(type);
    }

    @Override
    public Object readFrom(Class type, Type type1, Annotation[] antns, 
            MediaType mt, MultivaluedMap mm, InputStream in) 
            throws IOException, WebApplicationException {
        if (Widget.class.isAssignableFrom(type)) {
            return Widget.parseFrom(in);
        } else if (WidgetList.class.isAssignableFrom(type)) {
            return WidgetList.parseFrom(in);
        } else {
            throw new BadRequestException("Can't Deserailize");
        }
    }

    @Override
    public boolean isWriteable(Class type, Type type1, 
            Annotation[] antns, MediaType mt) {
        return Widget.class.isAssignableFrom(type) 
                || WidgetList.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Object t, Class type, Type type1, 
            Annotation[] antns, MediaType mt) {  return -1; }

    @Override
    public void writeTo(Object t, Class type, Type type1, 
            Annotation[] antns, MediaType mt, 
            MultivaluedMap mm, OutputStream out) 
            throws IOException, WebApplicationException {
        if (t instanceof Widget) {
            Widget widget = (Widget)t;
            widget.writeTo(out);
        } else if (t instanceof WidgetList) {
            WidgetList list = (WidgetList)t;
            list.writeTo(out);
        }
    }  
}