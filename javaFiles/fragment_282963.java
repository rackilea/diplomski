public static void main(String[] args) {
            String prompt1 = "Please enter the name of the Killer Robot or enter QUIT to exit.";
            String prompt2 = "Please enter the main weapon for the robot";
            String prompt3 = "Please enter the number of kills for this robot";
            Scanner userInput = new Scanner(System.in);

            Vector <KillerRobot> robotDetails = new Vector <KillerRobot>();
            KillerRobot robot;


            //prime the loop
            System.out.println(prompt1); 
            String userEntry = userInput.next();

            while(!userEntry.equals("QUIT")){
                robot = new KillerRobot();
                robot.setName(userEntry);

                System.out.println(prompt2);
                String b  = userInput.next();
                robot.setMainWeapon(b);

                System.out.println(prompt3);
                int c = userInput.nextInt();
                robot.setNumberOfKills(c);

                robotDetails.add(robot);

                //verify repeat
                System.out.println(prompt1); 
                userEntry = userInput.next();
            }

            if(robotDetails.size() < 1){
                System.out.println("No robots");
            } else {
                for(KillerRobot i : robotDetails){
                    System.out.println(i);
                }
            }

            System.out.println("done");
        }