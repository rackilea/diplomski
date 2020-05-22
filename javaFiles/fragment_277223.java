@Valid
@NotNull
@JsonProperty("logging")
private LoggingFactory loggingFactory = new LoggingFactory();
public LoggingFactory getLoggingFactory()
{
    return loggingFactory;
}