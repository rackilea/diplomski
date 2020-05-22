String name = "Just for Testing";
int greatestVal = 0;

for (int i = 0; i < name.length(); i++)
{
    int curVal = (int)name.charAt(i);
    if(curVal > greatestVal)
        greatestVal = curVal;
}
char asChar = (char)greatestVal;
System.out.println("The character with the highest ASCII (encoding) number was " + asChar + " (with ASCII (encoding) " + greatestVal + ")");