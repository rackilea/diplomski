package security;

public class Credentials {
    private final String username;
    private final String password; 
    private final String type;

    public Credentials(String u, String p, String t) {
        this.username = u;
        this.password = p;
        this.type = t;    
    }
}

// you add the rest.