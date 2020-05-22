@Override
public String call() {
    try {
        String result = doConversion(textToConvert);
        return result ;
    } catch (Exception e) {
        // fallback computation that doesn't throw exception...
        String result = doSafeConversion(textToConvert);
        return result ;
    }
}