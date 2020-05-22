int index = string1.indexOf(string2);
if (index == -1)
{
    // Not found. What do you want to do?
}
else
{
    String result = string1.substring(0, index) + 
                    string1.substring(index + string2.length());
}