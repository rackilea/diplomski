public class Main1{

     @Autowired
     Provider<MessageStats> messageStats;

     public MessageStats getStats(){
        messageStats.get().setCount(10);
     }
 }