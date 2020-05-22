public static void main (String[] args) {
    String input = "yaaaaaaaay:axaxaxaxa:yaaaaaaay";

    System.out.println(replaceMiddle(input, ':'));
}

public static String replaceMiddle(String input, char divider) {    
    String result = input;

    String regex = divider + "(\\w+)" + divider;
    Matcher matcher = Pattern.compile(regex).matcher(input);

    if(matcher.find()){         
        String mid = matcher.group(1).replace( "a", "X");

        result = matcher.replaceAll(divider + mid + divider);
    }

    return result;
}