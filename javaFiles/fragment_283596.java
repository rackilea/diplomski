private final static int[] NUMBERS= {1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
private final static String[] LETTERS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

public static String returnRoman(int number)
{
    int index=0;
    for(int i=0;i<NUMBERS.length;i++)
    {
        if(NUMBERS[i]==number)
        {
            index=i;
            break;
        }
    }
    if(index==0)
    return "Not found";
    else
    return LETTERS[index];
}