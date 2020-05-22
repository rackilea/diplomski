String normal = "abcdefghijklmnopqrstuvwxyz_,;.?!/\\'";
String split  = "ɐqɔpǝɟbɥıظʞןɯuodbɹsʇnʌʍxʎz‾'؛˙¿¡/\\,";
//maj
normal += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
split  += "∀qϽᗡƎℲƃHIſʞ˥WNOԀὉᴚS⊥∩ΛMXʎZ";
//number
normal += "0123456789";
split  += "0ƖᄅƐㄣϛ9ㄥ86";

String str = "So my question is that , is there any trick/method/any clue to do it in programmatic way ?";
String newstr = ""; 
char letter;
for (int i=0; i< str.length(); i++) {
    letter = str.charAt(i);

    int a = normal.indexOf(letter);
    newstr += (a != -1) ? split.charAt(a) : letter;
}
System.out.println(new StringBuilder(newstr).reverse().toString());