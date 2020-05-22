public static void main(String[]args)
{
    Scanner input = new Scanner(System.in);
    System.out.print("Numbers: ");
    double cumulativeSum = 0;

    String line = input.nextLine();

    String[] numbers = line.split(" ");

    for(String number : numbers){
        cumulativeSum += Double.parseDouble(number);
        System.out.println(cumulativeSum);
    }

    input.close();
}