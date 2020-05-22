import java.io.OutputStream;
import javax.xml.stream.XMLStreamWriter;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.staxutils.StaxUtils;


public class CdataWriterInterceptor extends AbstractPhaseInterceptor<Message> {

    public CdataWriterInterceptor() {
        super(Phase.PRE_STREAM);
        addAfter(AttachmentOutInterceptor.class.getName());
    }

    @Override
    public void handleMessage(Message message) {
        System.out.println("############# CdataWriterInterceptor Executed #######################");
        message.put("disable.outputstream.optimization", Boolean.TRUE);
        XMLStreamWriter writer
                = StaxUtils.createXMLStreamWriter(message.getContent(OutputStream.class));
        message.setContent(XMLStreamWriter.class, new CDataXMLStreamWriter(writer));
    }
}