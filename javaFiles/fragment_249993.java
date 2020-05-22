public interface Module {

    public enum CATEGORY implements Serializable {
        INPUT,
        OUTPUT,
        LIGHTS,        
        COMMUNICATION
    }
    public enum TYPE implements Serializable {
        INPUT,
        OUTPUT,
        ANALOG,
        DIGITAL
    }
}