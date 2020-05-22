@RestController
public class AccountsRestController {

    @RequestMapping("/accounts/alerts")
    public SseEmitter getAccountAlertsNoPathVariable(HttpSession session) {

        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        Thread t1 = new Thread(() ->{
            try {
                int i = 0;
                // Send 10000 messages
                while(++i<=10000){
                    Thread.sleep(1000);
                    System.out.println("Sending");
                    try{
                        emitter.send(new Alert((long)i, "Alert message"+i));
                    }catch(ClientAbortException cae){
                        //The client is not there anymore, we get out of the loop
                        i = 10000;
                    }
                }
                emitter.complete();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        return emitter;
    }