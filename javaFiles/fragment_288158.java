import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class CdataInterceptor extends AbstractPhaseInterceptor<Message> {

    public CdataInterceptor() {
        super(Phase.MARSHAL);
    }

    public void handleMessage(Message message) {
        message.put("disable.outputstream.optimization", Boolean.TRUE);
        XMLStreamWriter writer = (XMLStreamWriter) message.getContent(XMLStreamWriter.class);
        if (writer != null && !(writer instanceof CDataContentWriter)) {
            message.setContent(XMLStreamWriter.class, new CDataContentWriter(writer));
        }
    }

    public void handleFault(Message messageParam) {
        System.out.println(messageParam);
    }
}