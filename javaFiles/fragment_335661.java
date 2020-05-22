public class MultiFontField extends JTextPane {

    private StringBuilder content;

    public MultiFontField() {
        super();
        this.content = new StringBuilder("<html>");
        this.setContentType("text/html");
    }

    public MultiFontField appendText(String text, String font) {
        content.append("<font face=\"").append(font).append("\">").append(text).append("</font>");
        return this;
    }

    public void finaliseText() {
        this.setText(content.append("</html>").toString());
    }
}