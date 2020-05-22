public static void main(String[] args) {
    try (Scanner input = new Scanner(new File(
            System.getProperty("user.home"), "HTML_1.txt"))) {
        while (input.hasNextLine()) {
            String html = stripHtmlTags(input.nextLine().trim());
            if (!html.isEmpty()) { // <-- removes empty lines.
                System.out.println(html);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}