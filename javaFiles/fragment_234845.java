String ohhai;
String duh = et.getText().toString();
int number = Integer.parseInt(duh);
List<String> myCollection=new ArrayList<String>();
EditText stuff;
int editt;
String loggy;
for(int z = 0; z < number; z++){
    stuff = (EditText)findViewById(z);
    editt = stuff.getId();
    loggy = Integer.toString(editt);
    Log.e("How Many", loggy);
    ohhai = stuff.getText().toString();
    myCollection.add(ohhai);
}

String [] arr = myCollection.toArray(new String[myCollection.size()]);
String separator = "0";
StringBuffer result = new StringBuffer();
if (arr.length > 0) 
   result.append(arr[0]);
for (int h=1; h < arr.length; h++) {
    result.append(separator);
    result.append(arr[h]);
}