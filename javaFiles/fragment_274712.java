String input = "PRODUCT,,1/2\" 18V CORDLESS XRP LI-LON DRILL/DRIVE,P,2510906459,,DEWALT TOOLS,,,<br><img src=\"http://example.com/image.png\"><br><br><p><b>UNIT OF MEASURE: EA<br><br> QTY PER UNIT OF MEASURE: 1<br><br> MINIMUM ORDER QUANTITY: 1<br></P></b>DEWALT TOOLS DCD960KL - 1/2\" 18V CORDLESS XRP LI-LON DRILL/DRIVER KIT - XRP™ CORDLESS DRILLS - BEST IN CLASS LENGTH FOR IMPROVED BALANCE AND BETTER CONTROL|LED WORKLIGHT PROVIDES INCREASED VISIBILITY IN CONFINED SPACES|PATENTED 3-SPEED ALL-METAL TRANSMISSION MATCHES THE TOOL TO TASK FOR FASTEST APPLICATION SPEED AND IMPROVED  - EQUAL TO 115-DCD960KL,";
    Reader reader = new StringReader(input);

    CsvParserSettings settings = new CsvParserSettings(); //many options here, check the tutorial.
    settings.setNullValue("<BLANK>"); //use that to obtain <BLANK> to represent nulls

    String[] row = new CsvParser(settings).parseAll(reader).get(0);
    for(String element : row){
        System.out.println(element);
    }