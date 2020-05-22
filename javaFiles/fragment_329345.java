public static void main(String[] args)
{
    int count=0;
    for(int num=12;num<=54321;num+=12)
    {
        boolean repetition=false;
        int digits[]=new int[10];
        int length=0;
        int tempNum = num; // Here
        while (tempNum !=0)
        {
            digits[length++]=tempNum %10;
            tempNum =tempNum /10;
        }
        for(int i=0; i<length; i++)
        {
            for(int j=0; j<length; j++)
            {
                if(i!=j)
                {
                    if(digits[i]==digits[j])
                    {
                        repetition=true;
                        break;
                    }
                }
            }
        }

        if(repetition==false)
        {count++;}
    }
    System.out.println("There are "+count+" numbers satisfying the condition");
}