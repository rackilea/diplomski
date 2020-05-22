@Plugin(name = "NewLayoutConverter", category = "Converter")
@ConverterKeys({"custLayConv"})
public class NewLayoutConverter extends LogEventPatternConverter
{

    /**
     * Constructs an instance of LoggingEventPatternConverter.
     *
     * @param name  name of converter.
     * @param style CSS style for output.
     */
    protected NewLayoutConverter( String name, String style )
    {
        super( name, style );
    }

    @Override public void format( LogEvent event, StringBuilder toAppendTo )
    {

    }
}