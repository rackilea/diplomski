public static void main(String[] args) {
    // Input string with \n newlines
    String input = "2007-11-11 @South Alabama            72  Sam Houston St           54           \n2007-11-11 Auburn                    91  Detroit                  47          \n2007-11-11 @Missouri KC              65  Air Force                59           \n2007-11-11  Ga Southern              67 @Stetson                  51   ";
    // The regex with four matching groups, backslashes escaped
    String regex = "^\\d{4}-\\d{2}-\\d{2}\\s+([^\\d]+)[\\d]+\\s+([^\\d]+)[\\d]+\\s*$";
    // Pattern with multiline and insensitive options
    Pattern p = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE );
    // Match each line in the input
    Matcher m = p.matcher(input);
    // Loop over the matches
    while (m.find()){
        // first team name
        String first = m.group(1).trim();
        // first team score
        Integer firstScore = new Integer(m.group(2).trim());
        // second team name
        String second = m.group(3).trim();
        // second team score
        Integer secondScore = new Integer(m.group(4).trim());

        // is the first team the home team?
        if ( first.startsWith("@") ){
            // did they win?
            if (firstScore > secondScore){
                System.out.println("The home team " + first + " won " + firstScore + " to " + secondScore + " over " + second);
            } else {
                System.out.println("The home team " + first + " lost to " + second + " " + firstScore + " to " + secondScore);
            }
        } else 
        // is the second team the home team?
        if ( second.startsWith("@") ){
            // did they win?
            if (secondScore > firstScore){
                System.out.println("The home team " + second + " won " + secondScore + " to " + firstScore + " over " + first);
            } else {
                System.out.println("The home team " + second + " lost to " + first + " " + secondScore + " to " + firstScore);
            }
        } else {
            System.out.println("Both teams - " + first + " and " + second + " - were away.");
        }
    }
}