guess = keyboard.nextInt(); 
    while (guess != random) {
        if (guess > random) {
            System.out.print("Lower!");
            attempts += 1; 
        }
        else {
            System.out.print("Higher!");
            attempts +=1;
        }
     guess = keyboard.nextInt();
    }