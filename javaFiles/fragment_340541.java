@PostConstruct
    public void setup() {
        // check the stuff that you need.
        if (condition) {                
            throw new IllegalStateException();
        }
    }