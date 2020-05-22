public class FactoryAccessController {

    private Factory factory;

    void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Factory getFactory() {
        return factory;
    }

}