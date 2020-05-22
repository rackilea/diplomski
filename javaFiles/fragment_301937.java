String[] parts = newmenuItemsString.split(",");
String[] myFourStrings = new String[4];

System.arraycopy(parts, 0, myFourStrings, 0, parts.length);

if (parts.length == 3) {
    myFourStrings[3] = "0";
}