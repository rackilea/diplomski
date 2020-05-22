StringBuilder b = new StringBuilder();
b.append("(");

for(int i = 0; i < arrayTeste.length; ++i) {
   if(i != 0)
     b.append(",");

   b.append(arrayTeste[i]);
}
b.append(")");
String s = b.toString();