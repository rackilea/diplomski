String myString = "==blah=";
int count = 0;
int i = 0;
while (myString.charAt(i++) == '=')
{
    count++;    
}
i = myString.length() - 1;
while (myString.charAt(i--) == '=')
{
    count++;
}