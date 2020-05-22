public class Token {

    private final AccessTokenClient tokenRetriever;
    private final Object monitor;
    private volatile boolean isExpired = true;
    private volatile String token = "";

    public Token(AccessTokenClient tokenRetriever) {
        this.tokenRetriever = tokenRetriever;
        this.monitor = new Object();
    }

    public String getToken() {
        if (this.isExpired) {
            synchronized (this.monitor) {
                // intended double check!
                if (this.isExpired) {
                    this.token = this.tokenRetriever.retrieveToken();
                    this.isExpired = false;
                }
            }
        }

        return this.token;
    }
}