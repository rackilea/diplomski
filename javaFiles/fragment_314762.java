public static void main(String[] args) {
    Scanner textIn = new Scanner(System.in);
    System.out.println("Try to guess what number I am thinking of.");
    //X is the int I want to change
    int x = -1;

    //Z is the one I am comparing x to
    int z = 10;

    while(x != z)
    {
        x = textIn.nextInt();
        if(x == z)
        {
            System.out.println("You got it right!");
        }

        else if(x < z)
        {
            System.out.println("Try a higher number.");
        }
        else
        {
            System.out.println("Try a lower number.");
        }

    }
    System.out.println("Great job!")
}