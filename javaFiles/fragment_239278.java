public class ConverterTask extends Task<String> {

    private final String textToConvert ;

    public ConverterTask(String textToConvert) {
        this.textToConvert = textToConvert ;
    }

    @Override
    public String call() throws Exception {
        String result = doConversion(textToConvert); // may throw exception...
        return result ;
    }
}