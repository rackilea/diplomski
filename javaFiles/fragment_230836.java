public static void printWordBackwards (String s)
{
//Please note that this is greater than or equal to not less than or equal to.
    //for (int i = s.length()-1 ; i<= 0 ; i--)  ORIGINAL
    for (int i = s.length()-1 ; i>= 0 ; i--)
    {
        System.out.print(s.charAt(i));
    }
    System.out.println();
}
public static boolean isPerfect (int i)
{
//This is an infinite loop.  K is always 1, and i subtracts k and adds 1 to it meaning it will never end it should be as follows below.
// Please note that this does not mean it's a perfect answer, I simply fixed his original mistake
//In number theory, a perfect number is a positive integer that is equal to the sum of its proper positive divisors,
//for (int k = 1; i > 0; i++)  ORIGINAL
for (int k = 1; i > 0; k++)
{
    i -= k;
}
if (i == 0)
{
    return true;
    }
return false;
}

//More correct isPerfect using the http://en.wikipedia.org/wiki/Perfect_number document 
//and the statement that all even perfect numbers are of the form 
//2^(p-1)*((2^p)-1)
// and that odd perfect numbers are either rare or don't exist.
public static boolean betterIsPerfect(int i)
{
    return i==Math.pow(2, i-1)*(Math.pow(2,p)-1);
}