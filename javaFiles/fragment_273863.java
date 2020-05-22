public class grading {
public static void main (String args[]){
    boolean run = true;//this code together with bottom keep loop running
    while(run){ //the code inside this brackets will continue the loop

        int yourScore;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Score or E to exit: ");
        //checking if the input is integer or not
        if(input.hasNextInt()){ 
            yourScore = input.nextInt();

            if (yourScore < 60 && yourScore >=0){
                System.out.println("You had an F, Sorry!");
            }
            else if (yourScore >=60 && yourScore < 70){
                System.out.println("You had an D, Study more!");
            }
            else if (yourScore >=70 && yourScore < 80){
                System.out.println("you had an C, you can do Better!");
            }
            else if (yourScore >= 80 && yourScore < 90){
                System.out.println("You had an B, very Well done!");
            }
            else if ( yourScore >=90 && yourScore <= 100){
                System.out.println("you had an A, you are Great!");
            }
            else
                System.out.println("Incorrect Input!");
        }
        // checking if the input is string
        else if(input.hasNext()){
            //assigning input to String varible
            String userInput = input.next();
            //comparing the input value with letter e ignoring the case
            if(userInput.equalsIgnoreCase("e")){
                run = false;
            }
            else{
                System.out.println("Invalid key. Press e to exit");
            }
        }

    }
}
}