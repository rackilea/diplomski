@MessageMapping("/hello")
@SendTo("/topic/greetings")
public Greeting greeting(HelloMessage message) throws Exception {
    Thread.sleep(3000); 
    return new Greeting("Hello, " + message.getName() + "!");
}