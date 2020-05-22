public class CustomSoapFaultOutInterceptor extends AbstractSoapInterceptor {
    private static final Log logger = LogFactory.getLog(CustomSoapFaultOutInterceptor.class);

public CustomSoapFaultOutInterceptor() {
        super(Phase.MARSHAL);
        getAfter().add(Soap11FaultOutInterceptor.class.getName());
    }
    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        Fault fault = (Fault) message.getContent(Exception.class);
        logger.error(fault.getMessage(), fault);
    //delete the Mule Exception to have the one throw by the component in the SoapMessage
        Throwable t = getOriginalCause(fault.getCause());
        fault.setMessage(t.getMessage());
    }
    private Throwable getOriginalCause(Throwable t) {
        if (t.getCause() == null || t.getCause().equals(t))
            return t;
        else
            return getOriginalCause(t.getCause());
    }
}

//And then this into mule-config.
<cxf:jaxws-service>
   <cxf:outFaultInterceptors>
      <spring:bean class="is.tr.mule.interceptor.CustomSoapFaultOutInterceptor"/>
   </cxf:outFaultInterceptors>
</cxf:jaxws-service>