public enum GreetingStyle 
{ 
    HEY("Hey"),
    HELLO("Hello");

    GreetingStyle(String text) {
        this.text = text;
    }

    public final String text;
}