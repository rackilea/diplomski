public static String Obfuscation(String string_to_Obfuscate){
String Vowel_Letters = "AEIOUY";
String Result_after_Obfuscation = "";
for (int i = 0; i < string_to_Obfuscate.length(); i++) {
    if (Vowel_Letters.contains(Character.toString(string_to_Obfuscate.charAt(i))))                 
    {
        Result_after_Obfuscation =  Result_after_Obfuscation + "OB" + Character.toString(string_to_Obfuscate.charAt(i)) ;
    }
    else {
        Result_after_Obfuscation =  Result_after_Obfuscation + Character.toString(string_to_Obfuscate.charAt(i));
    }
} 
System.out.print("After obfuscation: "+Result_after_Obfuscation);
return Result_after_Obfuscation; 
}