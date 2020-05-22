int n=10; //This is your Number
int i = 0;
for(i=n;i>=1;i--)
    if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i)
        break;
System.out.println(i);