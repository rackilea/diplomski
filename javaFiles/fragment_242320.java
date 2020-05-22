try(Scanner n1 = new Scanner(System.in))
{
    num = n1.nextInt();
}

try(Scanner n2 = new Scanner(System.in))
{
    num = n2.nextInt();  // will throw an exception
}