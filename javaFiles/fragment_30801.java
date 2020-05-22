ArrayStack<String> e = new ArrayStack<String>(n);
    char ch=0;
    int op1,op2,result=0;
    for(int i=0; i<n; i++)
    {
       if(Character.isDigit(izraz[i]))
       {
         final StringBuilder number= new StringBuilder();

         while (izraz[i] != ' ') {
           number.append(izraz[i]);
           i++;    
         }

         e.push(number.toString());

          continue;
       }
        if(izraz[i]=='+' || izraz[i]=='-' || izraz[i]=='/' || izraz[i]=='*')
       {
           ch=izraz[i];

           op1 =Integer.parseInt(e.pop());
            //System.out.print(op1+" ");

           op2 =Integer.parseInt(e.pop());