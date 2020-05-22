String[] formats = new String[] {"dd/MM/yyyy", "dd/MM/yyyy HH:mm:ss"};
String input = "25/09/2015 10:25:31";
Date result = null;

for (String format: formats) {
    if (input != null && format.length() == input.length()) {
        try {
            SimpleDateFormat sdFormat = new SimpleDateFormat(format);
            result = sdFormat.parse(input);
            break;
        }
        catch (ParseException e) {
        }
    }
}