ArrayList<String> arrList = new ArrayList<String>();

for (int i=0; i<arr.length(); i++) {
     arrList.add(arr[i]); //add old values to arraylist
}
// add new string to it: 
arrList.add(toSave);

//Get back your array
String [] array = arrList.toArray(new String[arrList.size()]);