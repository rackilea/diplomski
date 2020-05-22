Scanner sc = new Scanner(System.in);
            for (int b=0; b < 5; b++) {

               System.out.println("please enter match result:");
               String s = sc.nextLine();

               String input[] = s.split(":"); // parse strings in between the dash character
               for(String temp : input ) {
                    String hometeam = input[0];
                    String awayteam = input[1];
                    String homescore = input[2];
                    String awayscore = input[3];
               } 
               System.out.println(input[0]);
            }