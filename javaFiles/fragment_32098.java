private static void matchParts(String line){
   Pattern pattern = Pattern.compile("Called\":\"(\\+\\d{11}).*\"Duration\":\"(\\d+)");
   Matcher matcher = pattern.matcher(line);
   String phone;
   String status;
   while (matcher.find()) {
      System.out.println("phone:" +matcher.group(1) + ", duration: "+matcher.group(2) );
   }
}