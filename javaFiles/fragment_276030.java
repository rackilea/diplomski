public interface EmailService {

    void send(EmailDetails details);

    class EmailDetails {
        private String from;
        private String to;
        private String messageTemplate;
        // etc...
    }
}