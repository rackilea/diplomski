int n=54321;char ch;
String s=Integer.toString(n);
int l= s.length();
for(int i=48;i<=57;i++)    //ascii values from 0 - 9
{
    for(int j=0;j<l;j++)
    {
      ch=s.charAt(j);
      if(ch==(char)i)    // checking if a digit equals a number
      {
        System.out.print(ch);
      }
    }
}