public static void main(String[] args)
{

    Scanner keyboard = new Scanner(System.in);

    double avg = 0.0;
    for (int i = 1; ;i++)
    {
        if (!keyboard.hasNextDouble()) break;
        double next = keyboard.nextDouble();
        avg = (avg * (i - 1) + next) / i;
    }
    System.out.println(avg);
}