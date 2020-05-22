Scanner geek = new Scanner(System.in);

        long taken_number;
        String answer;
        String answer_not_recognized = "You didn't enter any of the recognized answers.";
        String if_answer_is_no = "'Kay. Whatever.";
        boolean firstTime = true;

        while(true)
        {
            if(firstTime)
                System.out.println("Do you want to know the square of a number? (Y/N)");
            else
                System.out.println("Do you want to know the square of another number? (Y/N)");
            answer = geek.nextLine();
            if (answer.equalsIgnoreCase("y"))
            {
                System.out.println("The number you want to know the square of is:");
                taken_number = geek.nextLong();
                System.out.println("That number squared is " + taken_number * taken_number + ".");
                answer = geek.nextLine();
            }
            else if (answer.equalsIgnoreCase("n")) {
                System.out.println(if_answer_is_no);
                break;
            } else {
                System.out.println();
                System.out.println(answer_not_recognized);
                break;
            }
            if(firstTime)
                firstTime = false;
        }