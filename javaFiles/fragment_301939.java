int maxItems = 6;
String[] parts = newmenuItemsString.split(",");
String[] myStrings = new String[maxItems];

if (parts.length < myStrings.length) {
    System.arraycopy(parts, 0, myStrings, 0, parts.length);
} else {
    System.arraycopy(parts, 0, myStrings, 0, myStrings.length);
}

for (int i = 0; i < myStrings.length; i++)
{
    if (myStrings[i] == null)
    {
        myStrings[i] = "0";
    }
}

String s1part1 = myStrings[0];
String s1part2 = myStrings[1];
String s1part3 = myStrings[2];
String s1part4 = myStrings[3];