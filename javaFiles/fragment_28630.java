@Component
@ConfigurationProperties("external.library.url")
public class BookStoreUrlProperties {

    private Empik empik = new Empik();
    private Merlin merlin = new Merlin();    
    // getters/setters    

    public BookStoreUrlProperties() {
    }

    public static class Empik {

        private String romances;
        private String biographies;
        private String crime;
        private String guides;
        private String fantasy;        
        // getters/setters    
    }

    public static class Merlin {

        private String romances;
        private String biographies;
        private String crime;
        private String guides;
        private String fantasy;    
        // getters/setters    
    }

}