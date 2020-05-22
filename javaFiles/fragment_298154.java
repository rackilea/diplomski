public static void main(String...strings) {     
    String inputString = "{\n" + "\"id\": 1,\n" + "\"data\":[\n" + "{\n" + "\"to\":123456789,\"name\":\"james\",\"value\":200\n" + "},\n" + "{\n" + "\"to\":123456789,\"name\":\"jhon\",\"value\":20\n" + "}]\n" + "}\n" + "";
    Pattern pattern = Pattern.compile("(?:\"name\":\")(.*?)(?:\"value\":)[0-9]*");
    Matcher m = pattern.matcher(inputString);

    while (m.find()) {
        String[] matches = m.group().split(",");
        String name = null, value = null;
        for (String match : matches) {
            if(match.contains("name")){
                name= match.substring(match.indexOf("name")+"name".length()).replaceAll("\"", "");
            }else if(match.contains("value")) {
                value= match.substring(match.indexOf("value")+"value".length()).replaceAll("\"", "");
            }
        }
        System.out.println("Bonjour Mr. "+name+" votre score est value "+value);
    }       
}