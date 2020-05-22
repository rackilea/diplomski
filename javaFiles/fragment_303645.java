boolean isHindi = false;
 for (char c: myString.toCharArray()) {
     if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.DEVANAGARI) {
         isHindi = true;
         break;
     }
 }