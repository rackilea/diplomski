@Component
public class UserCreatedEventHandler {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(UserCreatedEvent event) {    
        try{
            amazonEmailService.sendMail(user);
            System.out.println("Good, can send email.");
        }catch(Exception exception){
            System.out.println("Sad, fail to send email , so remove user from DB...");
            userService.remove();
        }
    }
}