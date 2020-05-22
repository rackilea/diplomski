String capital="";
int num=1;
String sentence= "Mi4";
int senLength= sentence.length();
int i=0;
while (i < senLength)//; in the while loop
{
    //String senStr=sentence.substring(i,i+1);  substring should be of 1st letter so (i,i+1) doesnot find letter in next iteration 
    char senChar= senStr.charAt(i);
    if (senChar >= 'A' && senChar <='Z')
    {capital= senStr;}
    else if (senChar >= 'a' && senChar <='z')
    {capital= capital+senStr;}
    else if (senChar >='2' && senChar<='9')
    {num= Integer.parseInt(senStr);}
    i++;
    //sentence=sentence.substring(i);same here in next iteration the string doesnot contains same lenght so it doesnot find char at i
}
System.out.println(capital);
System.out.println(num);