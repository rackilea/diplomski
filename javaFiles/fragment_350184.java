String line = "!!!Error deploying file order\\POST_ORDER_UpdateTaxAmountCurrInCo.sql at 22-JUL-16 08:07:Chathura aBhanakana1!!!Error deploying file order\\POST_ORDER_UpdateTaxAmountChathura aBhanakana1AAAAA !!!Error deploying file order\\POST";

String pattern = "([\\s\\S]*?)(!!!Error deploying file)";

// Create a Pattern object
Pattern r = Pattern.compile(pattern);

// Now create matcher object.
Matcher m = r.matcher(line);
while (m.find( )) {
  String str = m.group(1);
  if(str != null && !str.isEmpty()){
     System.out.println("Found value: " + str );
   }
}