public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Please enter an integer for the number of stars: ");
    int input = keyboard.nextInt();

    System.out.println(doStars(input));
}

public static String doStars(int n)
{
    //If n == 0 the recursion is done
    //Otherwise, reduce n by 1 and double the number of stars
    if(n == 0)
        return "*";
    else
    {
        String output = doStars(n - 1);
        return output + output;
    }
}