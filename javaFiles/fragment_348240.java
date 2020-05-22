public class ServiceFaultException extends Exception {
    private static final long serialVersionUID = 7399493976582437021L;
    private ServiceFault serviceFault;

    public ServiceFaultException(String message, ServiceFault serviceFault) {
        super(message);
        this.serviceFault = serviceFault;
    }

    public ServiceFault getServiceFault() {
        return serviceFault;
    }

    public void setServiceFault(ServiceFault serviceFault) {
        this.serviceFault = serviceFault;
    }
}