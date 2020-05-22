String quote = "blah blah 123 \"hello\" 234 \"world\"";

boolean quoteOpen = false;
StringBuilder sb = new StringBuilder(quote.length());
for (int index = 0; index < quote.length(); index++) {
    if (quote.charAt(index) == '"') {
        if (quoteOpen) {
            System.out.println("Quote: [" + sb.toString() + "]");
            quoteOpen = false;
            sb.delete(0, sb.length());
        } else {
            System.out.println("Text: [" + sb.toString() + "]");
            sb.delete(0, sb.length());
            quoteOpen = true;
        }
    } else {
        sb.append(quote.charAt(index));
    }
}
if (sb.length() > 0) {
    if (quoteOpen) {
        System.out.println("Quote: [" + sb.toString() + "]");
    } else {
        System.out.println("Text: [" + sb.toString() + "]");
    }
}