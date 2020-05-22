public long mainNumber()
{
    long number = 3;
    while(true)
    {
        boolean flag = true;
        for(int i = 2; i <= 10; i++) {
            if(number % i != 0) {
                flag = false;
                break;
            }
        }
        if(flag) break;
        else number++;
    }
    return number;
}

public static void main(String[] args)
{
    Smallest_multiple result =new Smallest_multiple();
    System.out.println("The Smallest Multiple: " + result.mainNumber());
}