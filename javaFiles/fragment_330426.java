public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter amount: ");
    int num = sc.nextInt();
    int r, SpacesAmount, re;
    for (r = 1; r <= num; r++)
    {
        for (SpacesAmount = num - r; SpacesAmount > 0; SpacesAmount--)
            System.out.print(" ");
        for (re = r; re >= 1; re--)
            System.out.print(re);
        for (re = 2; re <= r; re++)
            System.out.print(re);
        System.out.println();
    }
    for (r = 1; r <= num; r++)
    {
        for (SpacesAmount = r; SpacesAmount >= 1; SpacesAmount--)
            System.out.print(" ");
        for (re = num - r; re >= 1; re--)
            System.out.print(re);
        for (re = 2; re <= num - r; re++)
            System.out.print(re);
        System.out.println();
    }
}