Keyword[] array= set.toArray(new Keyword[0]);
String[] stringArray= new String[array.length];

for (int i=0; i<array.length; i++) {
    stringArray[i]= array[i].getThatString();
}