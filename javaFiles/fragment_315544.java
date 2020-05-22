public class ServerModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private FirstArray[] array;
    public ServerModel() {
    }
    public ServerModel(FirstArray[] array) {        
        this.array = array;
    }
}