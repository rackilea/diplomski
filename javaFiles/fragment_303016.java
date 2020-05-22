public class MainActivity extends AppCompatActivity implements MessageSender {

    @Override
    public void sendMessage(String message) {
        // call the service here
        socketService.sendMessage(message);
    }
}