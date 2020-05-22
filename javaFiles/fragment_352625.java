public static void main(String[] args) throws ParseException {
    int pickedNum, highestCounter = 0;
    Scanner s = new Scanner(System.in);
    int count[] = new int[10];

    while (true) {
        System.out.println("Please enter a numbr between 0-9 , -1 to exit:");
        pickedNum = s.nextInt();
        if (pickedNum != -1) {
            count[pickedNum]++;
        } else {
            break;
        }
    }

    int index1 = 0;
    for (int i : count) {
        System.out.println("The number " + index1 + " appears : " + i);
        index1++;
    }

    // Finding the number was typed the most
    for (int counter : count) {
        if (counter > highestCounter) {
            highestCounter = counter;
        }
    }

    // In case if you have more than one number that was typed the most
    Integer[] indexes = new Integer[10];
    int index2 = 0;
    for (int counter : count) {
        if (highestCounter == counter) {
            indexes[index2] = index2;
        }
        index2++;
    }

    System.out.print("The number(s) was typed the most is/are : ");
    for (Integer i : indexes) {
        if (i != null) {
            System.out.print(i + ", ");
        }

    }
}