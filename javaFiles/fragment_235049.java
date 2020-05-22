String[] types = new String[columnNameType.length];
String[] names = new String[columnNameType.length];

for(int i = 0 ; i< columnNameType.length; ++i){
   names[i] = columnNameType[i].split(" ")[0];
   types[i] = columnNameType[i].split(" ")[1];
}