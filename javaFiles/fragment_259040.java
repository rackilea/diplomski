public class ConverterSerializer extends StdConverter<Converter, String> {

@Override
public String convert(Converter value) {
    if(value instanceof DataConverter) {
        return "DataConverter";
    } ...

    return "";
}