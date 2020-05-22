public static void main(String[] args) 
{

    int [] nums = {4,8,16,24};

    int gcd = nums[0];
    for (int i=1 ; i<nums.length; i++)
        {
             gcd = Getgcd(gcd,nums[i]);
        }

  System.out.println("The GCD of your n numbers is "+ gcd);

}

private static int Getgcd(int a, int b)

{
   return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue(); 
}