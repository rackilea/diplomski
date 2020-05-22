public class MyListener {
    @Autowired
    private Repush repush;

    public void receiveMessage(String message) { 
        // ... some code
        // if message requires modification, then repush
        repush.push(message);
    }
}