for(i=s.length()-1; i>=0; i--){
   if(s.charAt(i) == '*' || s.charAt(i) == '/'){
        System.out.println(i);
        break; // keep value of i for substrings
   }
}