String [] str= "<tag>with some string </tag>";
String  s="";
boolean inTag = false;
for (i=0; i < str.length; i++)
{
    if (str[i].toString()=="<")
    {
        inTag = true;
    }
    else if (str[i].toString()==">")
    {
        inTag = false;
    }else{
        if (!inTag)
            s = s + str[i];
    }
}