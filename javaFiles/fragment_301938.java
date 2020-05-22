String[] parts = newmenuItemsString.split(",");
String[] myFourStrings;

if (parts.length != 4)
{

    myFourStrings = new String[4];

    System.arraycopy(parts, 0, myFourStrings, 0, parts.length);

    if (parts.length == 3)
    {
        myFourStrings[3] = "0";
    }

}
else
{
    myFourStrings = parts;
}

String s1part1 = myFourStrings[0];
String s1part2 = myFourStrings[1];
String s1part3 = myFourStrings[2];
String s1part4 = myFourStrings[3];