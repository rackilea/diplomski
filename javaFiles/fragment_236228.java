Scanner in = new Scanner(System.in);

int amountOfNumers;
System.out.println("How many number do you want to put? Amount: ");

amountOfNumers = in.nextInt();
while (amountOfNumers < 1) {
    System.out.println("Please enter a number greater than one:");
    amountOfNumers = in.nextInt();
}

int[] numbers = new int[amountOfNumers];

for (int i = 0; i < amountOfNumers; i++) {
    System.out.println("Input your " + (i + 1) + " number: ");
    numbers[i] = in.nextInt();
}

System.out.println("Your numbers are:");
Arrays.stream(numbers).forEach(System.out::println);