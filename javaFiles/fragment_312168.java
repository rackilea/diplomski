int numberOfPeople = 0;
while (numberOfPeople <= 0) {
    try {
        System.out.print("Enter the number of people: ");
        numberOfPeople = Integer.parseInt(input.nextLine());
    } catch (Exception e) {
        System.out.print("Wrong input!");
        numberOfPeople = 0;
    }
}
//continue with your life...