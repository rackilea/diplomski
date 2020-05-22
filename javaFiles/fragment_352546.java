public static void main(String[] args)
{       
    int basenum = 1;
    int exp = 2;//Irrelevant to the code, just a note for myself.
    exp = metoda(basenum);     
}

public static void metoda(int basenum) 
{
    int sum = 0;
    for(int i = 1; i <= 4; i++) 
    {
          sum += basenum * basenum;
          basenum++;
          System.out.println(sum);  
    }      
}