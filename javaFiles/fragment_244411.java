public class AuthenticationProvider {
    private Map<String, String> authTable;

    public AuthenticationProvider()
    {
        this.authTable = new HashMap<>();
    }

    public String authenticate(String input)
    {
        return this.authTable.get(input);
    }

    public void addAuthentication(String source, String expected)
    {
        if(!this.authTable.containsKey(source))
            this.authTable.put(source, expected);
    }
}