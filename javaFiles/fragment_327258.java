public static void main(String[] args) {
    String s = flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU", "HOLA", "MMMMH");
    System.out.println(s);
}

// Please note the parameter, it takes a various amount of Strings  
public static String flett(String ... values) {
    // create something that concatenates Strings (other options possible)
    StringBuilder sb = new StringBuilder();

    // the parameters are now an array of Strings, which you can "foreach"
    for (String s : values) {
        // check for empty ones and skip those
        if (!s.equals("")) {
            // append the first character of a valid parameter
            sb.append(s.charAt(0));
        }
    }

    return sb.toString();
}