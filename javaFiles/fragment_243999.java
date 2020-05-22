public class AbstractGreeting {
    private final String name;
    protected AbstractGreeting(String name) {this.name = name;}
    public void displayGreeting() {System.out.println(getGreeting() + " " + name + "!");}        
    protected abstract String getGreeting();
}