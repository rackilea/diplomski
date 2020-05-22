public class Redacted {
    public static void main(String[] args) {
        String text = "Hi John,\n"
            + "Please contact me at tom@email.com or 212-555-1212 or 313.555.1313.\n"
            + "Thank you.\n"
            + "Tom";
        System.out.println("Before:\n" + text + "\n");
        // replace email addresses
        text = text.replaceAll("[^@\\s]+@[^@\\s]+\\.[a-zA-Z]{2,}", "[REDACTED]");
        // replace phone numbers
        text = text.replaceAll("\\d{3}[-.]\\d{3}[-.]\\d{4}", "[REDACTED]");
        System.out.println("After:\n" + text + "\n");
    }
}