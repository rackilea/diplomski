//here you declare the list OUTSIDE:

 ArrayList<String> list = new ArrayList<String>();

  do {
            System.out.println("Add? (yes/no)");
            ask = scan.nextLine();
            if (ask.equals("yes")){

                //gather user info
                System.out.println("Last Name: ");
                String LastN = scan.nextLine();

                System.out.println("First Name: ");
                String FirstN = scan.nextLine();

                System.out.println("# of Children:");
                String Children = scan.nextLine();

                System.out.println("Address:");
                String Adr = scan.nextLine();

                System.out.println("Phone #:");
                String Pho = scan.nextLine();

                Date dategather = new Date();   
                String Date = String.format("%tD", dategather);

                //Input the data into an array
                String[] inf = {LastN,FirstN,Children,Adr,Date,Pho};

                Collections.addAll(list,inf);
                //so here you want to display what the person just entered:
                System.out.println("You Have Entered : \n Last Name: "+LastN+"  First Name: "+FirstN+" Children : "+Children+" Address: "+Adr+" Date of Birth: "+Date+" Phone Number: "+Pho);               

            }

            } while (ask.equals("yes"));