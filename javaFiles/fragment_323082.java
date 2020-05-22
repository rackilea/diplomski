String str = "some text p.o. box 12456 Floor 105 streetName Street";
Pattern p = Pattern.compile("(?i)\\bp\\.?\\s*o\\.?\\s*box\\s*(\\d+)(?:\\z|\\s)"); 
Matcher m = p.matcher(str); 
int count =0;
while(m.find()) {
      count++;
      System.out.println("Match: "+m.group(0));
      System.out.println("Digits: "+m.group(1));
      System.out.println("Match number "+count);
      System.out.println("start(): "+m.start());
      System.out.println("end(): "+m.end());
}