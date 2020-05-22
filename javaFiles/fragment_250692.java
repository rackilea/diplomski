Scanner scanner = new Scanner(System.in);
int maxNum = 8;
int[] arrayIn = new int[maxNum];
boolean duplicate;
int digCounter = 1;

// Run while we need numbers
while (digCounter <= maxNum) {
    //reset duplicate
    duplicate = false;
    //Get user input
    System.out.println("Enter digit " + digCounter + ":");
    int temp = scanner.nextInt();
    for (int i = 0; i <= digCounter - 2; i++) { //Loop through accepted numbers
        if (temp == arrayIn[i]) { //We have found a match
            duplicate = true;
            break;
        }
    }
    //Check if duplicate
    if (duplicate) {
        System.out.println("Sorry that number has already been added");
    } else {
        arrayIn[digCounter - 1] = temp;
        digCounter++;
    }
}
System.out.println(Arrays.toString(arrayIn));