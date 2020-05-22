if (input > 0) {
  int answer = 1;
  String stringAnswer = input + " =";
  for (int i = input; i >= 1; i--) {
    answer *= i;
    stringAnswer += " " + i
    if (i != 1) {
      stringAnswer += " x"
    }
  }

  System.out.println(stringAnswer)
  System.out.println("The factorial of " + input + " is " + answer)
} else {System.out.println("Invalid input! Program stopped.")}