int vowel_count = 0;
for(int index = 0; index < type_hold.length(); index++) {
    if((type_hold.charAt(index) =='a') || 
       (type_hold.charAt(index) =='e') || 
       (type_hold.charAt(index) =='o') || 
       (type_hold.charAt(index) =='i') || 
       (type_hold.charAt(index) =='u')){

         // character at vowel_index is a vowel.
         // you have encountered 1 more vowel! 
         System.out.println("Character at " + index + " is a vowel.");
         vowel_count ++;
     }
}

System.out.println("There are " + vowel_count + " vowels in " + type_hold);