private static void matchParts(String line){
   Pattern pattern = Pattern.compile(": \\[(\\w+),\\*(\\+\\d{11})\\*]");
   Matcher matcher = pattern.matcher(line);
   String phone;
   String status;
   while (matcher.find()) {
      System.out.println("phone:" +matcher.group(2) + ", status: "+matcher.group(1) );
   }
}