String input = "abcXXXXXabc";

    // Counter to store the number of quadruples found
    int quadrupleCounter = 0;

    // Loop over each character in the input string (skip the last 3 to prevent going out of bounds)
    for(int i = 0;i < input.length() - 3; i++) {
      // Get the current char in the string + the next 3
      char c1 = input.charAt(i);
      char c2 = input.charAt(i + 1);
      char c3 = input.charAt(i + 2);
      char c4 = input.charAt(i + 3);

      // Check if all 4 characters are equal
      if(c1 == c2 && c2 == c3 && c3 == c4) {
        quadrupleCounter++; // Increase the counter
      }
    }

    System.out.println(quadrupleCounter);