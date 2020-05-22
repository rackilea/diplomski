package foo.bar;

import java.util.Arrays;
import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.interceptor.OutgoingChainInterceptor;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceModelUtil;
import org.apache.cxf.ws.policy.PolicyOutInterceptor;

public class InternalActServiceFaultOutInterceptor extends AbstractSoapInterceptor {

    public InternalActServiceFaultOutInterceptor() {
        super(Phase.SETUP);
        addBefore(Arrays.asList(PolicyOutInterceptor.class.getName()));
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        Exchange exchange = message.getExchange();

        resetOrigInterceptorChain(message);
        resetFault(exchange);

        Message outMessage = createOutMessage(exchange);

        InterceptorChain chain = prepareNewInterceptorChain(exchange);
        chain.doIntercept(outMessage);
    }

    private InterceptorChain prepareNewInterceptorChain(Exchange exchange) {
        Message message = exchange.getOutMessage();
        bind(message);

        InterceptorChain chain = OutgoingChainInterceptor.getOutInterceptorChain(exchange);
        message.setInterceptorChain(chain);

        return chain;
    }

    private Message createOutMessage(Exchange exchange) {
        Endpoint ep = exchange.get(Endpoint.class);

        Message outMessage = ep.getBinding().createMessage();
        outMessage.setExchange(exchange);
        outMessage.setContent(List.class, new MessageContentsList(createSoapMessage()));

        exchange.setOutMessage(outMessage);
        return outMessage;
    }

    private void resetFault(Exchange exchange) {
        exchange.put(Exception.class, null);
    }

    private void resetOrigInterceptorChain(SoapMessage message) {
        InterceptorChain chain = message.getInterceptorChain();
        for(Interceptor<?> interceptor : chain) {
            chain.remove(interceptor);
        }
        chain.reset();
    }

    private void bind(Message message) {
        Exchange exchange = message.getExchange();
        BindingOperationInfo bop = unwrap(message.getExchange().getBindingOperationInfo());

        message.put(MessageInfo.class, bop.getOperationInfo().getOutput());
        message.put(BindingMessageInfo.class, bop.getOutput());

        bop = unwrap(ServiceModelUtil.getOperationForWrapperElement(exchange, bop.getName(), false));

        exchange.put(BindingOperationInfo.class, bop);
        if (bop != null) {
            exchange.put(BindingOperationInfo.class, bop);
            exchange.put(OperationInfo.class, bop.getOperationInfo());
        }
    }

    private BindingOperationInfo unwrap(BindingOperationInfo bop) {
        while(bop.getUnwrappedOperation() != null) {
            bop = bop.getUnwrappedOperation();
            return bop;
        }
        return bop;
    }

    protected Echo createSoapMessage() {
        Echo e = new Echo();
        e.setValue("Bye World!");
        return e;
    }

}