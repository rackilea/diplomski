package axistest;

import javax.xml.namespace.QName;
import javax.xml.soap.MimeHeaders;
import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

public class TestHandler1 extends BasicHandler {

@Override
public void init() {
    System.out.println("init called");
    super.init();
    System.out.println("init called");
}

@Override
public void cleanup() {
    super.cleanup();
    System.out.println("cleanup called");
}

@Override
public void invoke(MessageContext mc) throws AxisFault {
    System.out.println("invoke called");
    System.out.println("=----------------------------------=");
    MimeHeaders mimeHeaders = mc.getMessage().getMimeHeaders();
    mimeHeaders.addHeader("X-Test", "Hello");
    System.out.println("Headers : \n " + mimeHeaders);
}

public QName[] getHeaders() {
    System.out.println("getHeaders");
    return new QName[1];
}

}