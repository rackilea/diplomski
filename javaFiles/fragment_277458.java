while (playing){
    if (guess == -1){
        playing = false;
        break;
    }else if (!firstTimmer){
        got = true;
        System.out.print("Do you want to change the number range? Yes(1) No(2)");
        guess = input.nextInt();
        if (guess == 1){
            System.out.print("Insert the new x: ");
            x = 1+input.nextInt();
        }else if(guess == 2){
            System.out.println("Let's go then!");
        }else{
            System.out.print("I didn't ask for that number, x won't change.");
        }
        firstTimmer = true;
        //break;
    }else{