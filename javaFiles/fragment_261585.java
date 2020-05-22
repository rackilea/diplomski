int i=0;
for(i=0;i<nameData.length;i++){
    if(nameData[i]==null) break;   // count number of elements
}
String[] myString = new String[i];  // declare string
for(i=0;i<myString.length;i++){
    myString[i] = nameData[i];      // copy
}
// Create JList
final JList list = new JList(nameData);