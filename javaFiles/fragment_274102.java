public class ContentTypeTerm extends SearchTerm {
    @Override
    public boolean match(Message msg) {
        try {
            return msg.isMimeType("multipart/*");
        } catch (MessagingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}