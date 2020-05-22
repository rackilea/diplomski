import javax.xml.bind.Marshaller;
import javax.xml.stream.*;

public class MyMarshallerListener extends Marshaller.Listener {

    private XMLStreamWriter xsw;

    public  MyMarshallerListener(XMLStreamWriter xsw) {
        this.xsw = xsw;
    }

    @Override
    public void beforeMarshal(Object source)  {
        try {
            xsw.writeComment("Before:  " + source.toString());
        } catch(XMLStreamException e) {
            // TODO: handle exception
        }
    }

    @Override
    public void afterMarshal(Object source) {
        try {
            xsw.writeComment("After:  " + source.toString());
        } catch(XMLStreamException e) {
            // TODO: handle exception
        }
    }

}