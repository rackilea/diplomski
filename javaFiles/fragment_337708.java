class BaseResource {}
class Rate extends BaseResource {}
class GenericQuote extends BaseResource {}
class Payment extends GenericQuote {}

public class Test {

    public void handleMediationErrors(BaseResource response) {}

    public static void main(String[] args) {
        new Test().handleMediationErrors(new Payment());
        new Test().handleMediationErrors(new Rate());
        new Test().handleMediationErrors(new GenericQuote());
        new Test().handleMediationErrors(new Payment());
    }
}