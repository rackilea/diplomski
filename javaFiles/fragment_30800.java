ArrayStack<Character> e = new ArrayStack(n);
    char ch=0,res=0,a,b;
    int op1,op2,result=0,c=0;
    int z;
    for(int i=0; i<n; i++)
    {
       if(Character.isDigit(izraz[i]))
       {

          ch=izraz[i];

          e.push(ch);  


       }
        if(izraz[i]=='+' || izraz[i]=='-' || izraz[i]=='/' || izraz[i]=='*')
       {
           ch=izraz[i];

           op1 =e.pop()-'0';
            //System.out.print(op1+" ");

           op2 =e.pop()-'0';