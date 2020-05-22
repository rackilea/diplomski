public void fizzBuzz(int num)
{
    for (int i = 1; i < num + 1; i++)
    {
        if (fizzbuzz(i))
        {
            System.out.println("FizzBuzz");
        } 
        else if (fizz(i))
        {
            System.out.println("Fizz");
        } 
        else if (buzz(i))
        {
            System.out.println("Buzz");
        } 
        else {
            System.out.println(i);
        }
    }

}