public static String normalizeText(String string_to_encrypt){
String upper_string = string_to_encrypt.toUpperCase();
String Capital_Letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String Result_after_Normalization = "";
for (int i = 0; i < upper_string.length(); i++) {
    if (Capital_Letters.contains(Character.toString(upper_string.charAt(i))))                 
    {
        Result_after_Normalization =  Result_after_Normalization + Character.toString(upper_string.charAt(i));
    }
} 
System.out.print("After normalization: "+Result_after_Normalization); 
return Result_after_Normalization;
}