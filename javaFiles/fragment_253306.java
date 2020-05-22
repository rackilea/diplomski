public class Trial02 
{   
    public static void main( String[] args) 
    {       
    int[] bag = new int[100];
    bag[0] = 2; //first element of prime array
    int valid = 1;
    int i;
    boolean isPrime = true;
    String str = "";

    //starting from 3 it checks if a number is prime until array is full
    for( i=3; valid<bag.length; i++)
    {
        isPrime = true;
        for (int k = 2; k < i; k++)
        {
            if (i % k == 0)
            {
                isPrime = false;
                break;
            }
        }

        if (isPrime == true)
        {
            bag[valid++] = i;
        }
    }

    //printing results
    for(i=0; i < bag.length; i++)
        str = str + bag[i] + " ";
    System.out.println("zaa xd");
    System.out.println(str);
    }

}