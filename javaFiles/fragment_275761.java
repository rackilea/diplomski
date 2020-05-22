@Component
@Qualifier("emailService")
public class EmailServiceImpl implements MessageService {

    @Override
    public boolean sendMessage(String message) {
        System.out.println("EmailServiceImpl.sendMessage " + message);
        return true;
    }
}