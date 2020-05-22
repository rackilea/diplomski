@Value("${custom.format}")
public void createDateTimeFormatter(
    final String desiredDateFormat)
{
    formatter = DateTimeFormatter.ofPattern(desiredDateFormat);
}