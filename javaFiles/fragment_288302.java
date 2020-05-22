public class UrlTextPane extends JTextPane {

private final Pattern urlPattern = Pattern.compile(UrlUtil.URL_REGEX);

public UrlTextPane() {
    this.setEditable(false);
    this.addHyperlinkListener(new UrlHyperlinkListener());
    this.setContentType("text/html");
}

private class UrlHyperlinkListener implements HyperlinkListener {
    @Override
    public void hyperlinkUpdate(final HyperlinkEvent event) {
        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                Desktop.getDesktop().browse(event.getURL().toURI());
            } catch (final IOException e) {
                throw new RuntimeException("Can't open URL", e);
            } catch (final URISyntaxException e) {
                throw new RuntimeException("Can't open URL", e);
            }
        }
    }
};

@Override
/**
 * Set the text, first translate it into HTML:
 */
public void setText(final String input) {

    final StringBuilder answer = new StringBuilder();
    answer.append("<html><body style=\"font-size: 8.5px;font-family: Tahoma, sans-serif\">");

    final String content = StringEscapeUtils.escapeHtml(input);

    int lastIndex = 0;
    final Matcher matcher = urlPattern.matcher(content);
    while(matcher.find()) {
        //Append everything since last update to the url:
        answer.append(content.substring(lastIndex, matcher.start()));
        final String url = content.substring(matcher.start(), matcher.end()).trim();
        if(UrlUtil.isValidURI(url)) {
            answer.append("<a href=\"" + url + "\">"+url+"</a>");
        } else {
             answer.append(url);
        }
        lastIndex = matcher.end();
    }
    //Append end:
    answer.append(content.substring(lastIndex));
    answer.append("</body></html>");
    super.setText(answer.toString().replace("\n", "<br />"));
}