startTime = System.currentTimeMillis(); //get timestamp

//the condition is waaaay off, basically equals to while (true) - more on that later
while (curTime > 1000){
        input = TextIO.getlnDouble();

        if (input = Math.abs(randNum)){
            System.out.println("You got the correct answer");

        }   // End if statement

        else {
            System.out.println("You did not have the correct answer");
            System.out.println("The number was" + randNum + ".");

        }   // End else statement

    } // End while statement

curTime = System.currentTimeMillis(); //get timestamp again

System.out.println("Game took " + ((curTime-startTime)/1000) + " seconds");