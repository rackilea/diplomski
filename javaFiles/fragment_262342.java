public static void main(String[] args) {
     String reg = "%Warning: portfast should only be enabled on ports connected to a single\n host. Connecting hubs, concentrators, switches, bridges, etc. to this\n interface when portfast is enabled can cause temporary bridging loops.\n Use with CAUTION";
     String str = "%Warning: portfast should only be enabled on ports connected to a single\n host. Connecting hubs, concentrators, switches, bridges, etc. to this\n interface when portfast is enabled can cause temporary bridging loops.\n Use with CAUTIONTest is a testData is invalid%";
     Pattern regEx2 = Pattern.compile(reg);
     Matcher matcher = regEx2.matcher(str);
     int occurences = str.length() - str.replace("%", "").length();

     if (matcher.find() && occurences <= 1) {
        System.out.println("valid");
     } else {
        System.out.println("invalid");
     }

 }