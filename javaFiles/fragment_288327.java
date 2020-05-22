@Value("${custom.format}")
private String desiredDateFormat;

@PostConstruct
public void postConstruct()
{
    formatter = DateTimeFormatter.ofPattern(desiredDateFormat);
}