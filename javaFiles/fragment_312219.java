public void execute() 
    {
        Scanner scobj=new Scanner(System.in);
        String option1;
        int weekchoice;

        option1=scobj.nextLine();


        switch(option1)
        {
        case "a":
            System.out.println("Which week?(0-4)");
            weekchoice=scobj.nextInt();
            f1.getStores(storechoice).totalsalesforweek(weekchoice);
            break;

        default:
            System.out.println("I'm sorry you must choose a-g or q to quit");
            break;

        }
        scobj.close(); 
    }