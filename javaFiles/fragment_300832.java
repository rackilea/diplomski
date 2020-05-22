boolean isGreater(String v1, String v2){
   int[]numbers1 = getNumbers(v1);
   int[]numbers2 = getNumbers(v2);
   for(int i=0;i<numbers1.length()&&i<numbers2.length();i++){
      if(numbers1[i]>numbers2[i]) return true; //v1 > v2
      if(numbers1[i]<numbers2[i]) return false; //v1 < v2
   }
   if(numbers1.length()==numbers2.length()) return false; they're same
   return numbers1.length()>numbers2.length();
}