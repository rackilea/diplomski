public class ConverterFactory {

    public static AtoBConverter getAToBConverter() {        
        return new AtoBConverter();
    }

    public static BtoAConverter getBToAConverter() {        
        return new BtoAConverter();
    }

}