@Service
class MyMailService {

    private final SendGrid sendGrid;

    @Inject
    public SendGridMailService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    void sendMail() {
        Request request = new Request();
        // .... prepare request
        Response response = this.sendGrid.api(request);                
    }
}