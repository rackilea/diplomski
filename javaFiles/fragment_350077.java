public static boolean promptForYesNo(Scanner in, String prompt){
            System.out.println(prompt + "Yes or No?");   
            String userAnswer = in.next();
            userAnswer = userAnswer.toLowerCase();
            if (userAnswer.equals("yes") || userAnswer.equals("y") || 
                    userAnswer.equals("true")){
                return true;
            }
            else if(userAnswer.equals("no") || userAnswer.equals("n") || 
                    userAnswer.equals("false")){
                return false;
            }
            else {
                return promptForYesNo(in, prompt);
            }
        }