System.out.print("enter a number: ");
    int input = console.nextInt();

    if (input < 0) {
        input = input * (-1);
    }

    String nbr = String.valueOf(input);
    int strnbr = nbr.length();
    System.out.print("the digits of " + input + " are: ");
    int sum = 0;

    for (int i = 0; i < strnbr; i++) {
        String var = nbr.substring(i, i + 1);
        int var1 = Character.getNumericValue(var.charAt(0));
        System.out.print(var + " ");
        sum = sum + var1;
    }
    System.out.println();
    System.out.println("the sum is: " + sum);