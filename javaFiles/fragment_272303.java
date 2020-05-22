if (m.find()) {
   // The String matches with the pattern
   String link = m.group(2);    
   System.out.println("Draw #: "+link);
}  else {
   System.out.println("Input value doesn't match with the pattern");
}