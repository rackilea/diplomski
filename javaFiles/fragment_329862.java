private static HashMap<String, String> regexMap = new HashMap<>();
private static String regex2two = "(?<=[^\\d])(\\d)(?=[^\\d])";
private static String two = "0$1";

public static void main(String[] args) {

    regexMap.put("PT(\\d\\d)S", "00:$1");
    regexMap.put("PT(\\d\\d)M", "$1:00");
    regexMap.put("PT(\\d\\d)H", "$1:00:00");
    regexMap.put("PT(\\d\\d)M(\\d\\d)S", "$1:$2");
    regexMap.put("PT(\\d\\d)H(\\d\\d)S", "$1:00:$2");
    regexMap.put("PT(\\d\\d)H(\\d\\d)M", "$1:$2:00");
    regexMap.put("PT(\\d\\d)H(\\d\\d)M(\\d\\d)S", "$1:$2:$3");

    String[] dates = { "PT1S", "PT1M", "PT1H", "PT1M1S", "PT1H1S", "PT1H1M", "PT1H1M1S", "PT10H1M13S", "PT10H1S", "PT1M11S" };

    for (String date : dates) {
        String d = date.replaceAll(regex2two, two);
        String regex = getRegex(d);
        if (regex == null) {
            System.out.println(d + ": invalid");
            continue;
        }
        String newDate = d.replaceAll(regex, regexMap.get(regex));
        System.out.println(date + " : " +newDate);
    }    
}

private static String getRegex(String date) {
    for (String r : regexMap.keySet())
        if (Pattern.matches(r, date))
            return r;
    return null;
}