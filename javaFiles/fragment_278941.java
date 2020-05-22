public class TokenFactory {
    private static final Map<String, Token> INSTANCES = new ConcurrentHashMap<String, Token>();

    public Token create(String key) {
        if (INSTANCES.containsKey(key) { 
            return INSTANCES.get(key);
        } else {
            Token t = new Token(key);
            INSTANCES.put(key, t);
            return t;
        }
    }
}