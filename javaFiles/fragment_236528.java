String s = "K82v6686";
String rx = "(?=[^a-z]*[a-z][^a-z]*$)" +      // 1 lowercase letter check
            "(?=(?:\\D*\\d){6}\\D*$)" +       // 6 digits check
            "[a-zA-Z0-9]{8}";                 // matching 8 alphanum chars exactly
if (s.matches(rx)) {
    System.out.println("Valid"); 
}