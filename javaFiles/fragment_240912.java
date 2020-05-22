I resolved this by using below code
String removedUnicodeChar  = "DISPOSABLE COVERALL → XXL</Description></Order> ↔ ↕ ↑ ↓ → ABC";
Pattern pattern = Pattern.compile("[\\p{Cntrl}|\\uFFFD]");
Matcher m = pattern.matcher(removedUnicodeChar);
if(m.find()){
    System.out.println("Control Characters found");
    removedUnicodeChar = m.replaceAll("");
}