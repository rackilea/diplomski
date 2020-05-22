private static int counts(int lineNum, String s){
     int count0 = s.length();
     int count1 = s.replaceAll("[^aeiou]","").length();
     int count2 = s.replaceAll("[^bcdfghjklmnpqrstvwxyz]","").length();
     int calc = count0-count1-count2;
     System.out.printf("Line %02d:", lineNum);
     return calc;
 }