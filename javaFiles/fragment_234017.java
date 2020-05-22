package org.foo.bar;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.util.Arrays;
import java.util.List;

public class InternalActServiceFaultOutInterceptor extends AbstractSoapInterceptor {

    public InternalActServiceFaultOutInterceptor() {
        super(Phase.PRE_STREAM);
        addBefore(Arrays.asList(StaxOutInterceptor.class.getName(), AttachmentOutInterceptor.class.getName()));
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        Exception exception = message.getContent(Exception.class);
        if(exception != null) {
            message.getExchange().put(Exception.class, null);

            for(Class<?> contentFormat : message.getContentFormats()) {
                message.setContent(contentFormat, null);
            }

            message.setContent(List.class, new MessageContentsList(createSoapMessage(RegisterDocumentResponse.class)));
        }
    }

    protected <T> T createSoapMessage(Class<T> messageType) {
        // create your message
        return null;
    }

}