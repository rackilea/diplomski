String[] sample = { "FUTSTKACC26-MAY-2016", "FUTSTKACC28-APR-2016", 
        "FUTSTKACC30-JUN-2016", "FUTSTKADANIENT26-MAY-2016", 
        "FUTSTKADANIENT28-APR-2016", "FUTSTKADANIENT30-JUN-2016" };
String predefWord = "FUTSTK";
for (String input : sample) {
    if (input.startsWith(predefWord)) {
        input = input.substring(predefWord.length());
        // There are 11 characters in the date format
        String symbol = input.substring(0, input.length() - 11);
        String dateStr = input.substring(input.length() - 11);
        System.out.printf("symbol=%s, date=%s%n", symbol, dateStr);
    }
}