for (char letter = GettingUserInput(input); letter != 'q'; letter = GettingUserInput(input)) {
    if (letter =='a') {
        valueOfA = InputWasA();
        System.out.println(valueOfA);
     }

     if (letter =='b') {
         valueOfB = InputWasB();
         System.out.println(valueOfB);
     }

     if (letter =='c') {
         System.out.println("made it to C");
         hypotenuse = Math.sqrt((valueOfA*valueOfA)+(valueOfB*valueOfB));
         System.out.println("Hypotenuse is: "+hypotenuse);
     }
}

System.out.println("Program Closed");