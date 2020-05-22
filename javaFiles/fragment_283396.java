public interface EmailService {

    void send(EmailDetails details);

    class EmailDetails {
        private String from;
        private List<String> to = Lists.newArrayList();
        private String messageTemplate;
        //...
    }
}