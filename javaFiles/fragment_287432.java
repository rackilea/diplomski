String s = getContents();
org.json.JSonArray arr = new org.json.JSonArray(s);
String[] strs = new String[arr.length()];
for (int i = 0; i < arr.length(); i++) {
    strs[i] = arr.getString(i);
}