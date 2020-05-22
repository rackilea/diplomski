Scanner text = new Scanner(System.in);
    int[] first_in = new int[2];

    System.out.println("Please start data entry: \n");
    // Take in first variables (numbers)
    for(int i = 0; i<first_in[0]; i++) {
        first_in[i] = text.nextInt();
    }
    int n = first_in[0];