@Component
public class SmsServiceImpl implements MessageService {
    @Override
    public boolean sendMessage(String message) {
        System.out.println("SmsServiceImpl.sendMessage " + message);
        return true;
    }
}