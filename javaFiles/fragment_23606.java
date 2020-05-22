try {
    if (Integer.parseInt(number_one) <= 0 || Integer.parseInt(number_one) > 0) {
      System.out.print("Enter another number" + "\n");
      String number_two = keyInput.next();

      if (Integer.parseInt(number_two) <= 0 || Integer.parseInt(number_two) > 0) {

        if (Integer.parseInt(number_one) > Integer.parseInt(number_two)) {
          System.out.print(number_one + " is greater than " + number_two + "\n" + "\n");
        } else if (Integer.parseInt(number_one) < Integer.parseInt(number_two)) {
          System.out.print(number_one + " is less than " + number_two + "\n" + "\n");
        } else if (Integer.parseInt(number_one) == Integer.parseInt(number_two)) {
          System.out.print(number_one + " is equal to " + number_two + "\n" + "\n");
        }

      } else {
        System.out.println("Invalid number!" + "\n");
      }

    } else {
      System.out.println("Invalid number!" + "\n");
    }
  } catch (NumberFormatException e) {
    System.out.println("Not a valid number");
  }