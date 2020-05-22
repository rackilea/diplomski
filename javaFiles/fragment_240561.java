public static boolean find_match(String query, String text){
    String regex = "(?:^|\\s)(" + query.replaceAll(".(?!$)", "$0(?:\\\\s*)") + ")";
    //System.out.println("Regex -> " + regex);
    Pattern re = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);    
    return re.matcher(text).find();
 }