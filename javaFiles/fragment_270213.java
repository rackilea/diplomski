String[] ht_name = new String[9999];
        String[] at_name = new String[9999];
        int[] ht_score = new int[9999];
        int[] at_score = new int[9999];
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        int i=0;
                //do while loop starts
        do {

            System.out.println("Enter Home team name: ");

            ht_name[i] = scanstr.nextLine();

                if(!ht_name[i].equalsIgnoreCase("exit"))
                {
                    System.out.println("Enter Away team name: ");
                    at_name[i] = scanstr.nextLine();

                    System.out.println("Enter Home team score: ");
                    ht_score[i] = scanint.nextInt();


                    System.out.println("Enter Away team score: ");
                    at_score[i] = scanint.nextInt();

                    i++;
                } else {
                    break; //this statement exits the loop each time when 'exit' is typed in 
                }

            } while (true); //while (true) gives you infinite loop. So this loop is broken only when 'exit' is typed in
           //do while loop ends