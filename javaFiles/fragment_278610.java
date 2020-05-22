public class Controlleur {
    private SOAPMessage request;
    private String serviceName="test";

    public Controlleur(SOAPMessage request){
        System.out.println(serviceName);
        this.request=request;
    }
}