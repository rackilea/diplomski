Scanner scanner = new Scanner(System.in);
int maxNum = 8;
Set<Integer> numbers = new HashSet<>();
int digCounter = 1;

//Run while we need numbers
while (digCounter <= maxNum) {
    System.out.println("Enter digit " + digCounter + ":");
    int tempNumber = scanner.nextInt();
    if (numbers.contains(tempNumber)) { //If number is already chosen
        System.out.println("Sorry that number has already been added");
    } else { //If new number
        digCounter++;
        numbers.add(tempNumber);
    }
}
System.out.println(numbers);