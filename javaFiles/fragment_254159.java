if((str.charAt(i)=='a')||(str.charAt(i)=='e')||(str.charAt(i)=='i')||(str.charAt(i)=='o')||(str.charAt(i)=='u'))
{
    b = str.charAt(i);
    b +=1;
    char temp;
    temp = b;
    b = str.charAt(i);
    a.setCharAt(i,temp);
    continue;
}
a.setCharAt(i, str.charAt(i));