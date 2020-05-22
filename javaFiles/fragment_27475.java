private static final DEFAULT_RESPONSE = "I don't know what to say.";
private static final Map<String, String> RESPONSES = new HashMap<>();
static {
    RESPONSES.put("Apple", "Orange");
    RESPONSES.put("Hello", "Goodbye!"
    RESPONSES.put("Alexander", "The Great"
    RESPONSES.put("meat", "potatoes"
    RESPONSES.put("Turing", "Machine"
    RESPONSES.put("Special", "\o/"
}

public static String respond(String input) {
    String response = RESPONSES.get(input);
    if (response == null) {
        response = DEFAULT_RESPONSE;
    }
    return response;
}