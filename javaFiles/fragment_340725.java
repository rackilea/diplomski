/**
 * Mask email addresses in logging lines.
 */
public class MaskingLayout extends PatternLayout {
    private static Pattern EMAIL = Pattern.compile("([^.@\\s]+)(\\.[^.@\\s]+)*@([^.@\\s]+\\.)+([^.@\\s]+)");

    @Override
    public String format(LoggingEvent event) {
        Matcher matcher = EMAIL.matcher(super.format(event));
        return matcher.replaceAll("xxx@xxx.xxx");
    }

}