Scanner inFile = null; //setting scanned file as null

    double weeklyPay=0,sunPay=0, monPay=0, tuesPay=0, wedPay=0, thurPay=0, friPay=0, satPay=0, overPay=0; //initializing variables
    int weekNumber=1; //which week it is

    DecimalFormat twodigits= new DecimalFormat("0.00"); //formating numbers

    try
    {
        inFile =new Scanner(new File("prog213a.dat")); //reading file 
    }
    catch(Exception e) //if file doesn't exist
    {
        System.out.println("File not found"); //output that file doesn't exist
        System.exit (0); //exit program
    }

    while (inFile.hasNextLine()) //while the file has a next line of data
    {
        System.out.println("Week " + weekNumber + ": "); //header

        int sunHours = inFile.nextInt();  //getting the hours for each day
        int monHours = inFile.nextInt();
        int tuesHours = inFile.nextInt();
        int wedHours = inFile.nextInt();
        int thurHours = inFile.nextInt();
        int friHours = inFile.nextInt();
        int satHours = inFile.nextInt();
        int weeklyHours = monHours + tuesHours + wedHours + thurHours + friHours; //weekly hours is summation of hours

        System.out.println(sunHours + " " + monHours + " " + tuesHours + " " + wedHours + " " + thurHours + " " + friHours + " " + satHours); //output

        //calculating daily pay depending on the specifications

        if(sunHours>8) 
            sunPay=(((sunHours-8)*55.50)+240)*2.25;
        else
            sunPay=(sunHours*30)*2.25;

        if(monHours>8)
            monPay=((monHours-8)*55.50)+240;
        else
            monPay= monHours*30;

        if(tuesHours>8)
            tuesPay=((tuesHours-8)*55.50)+240;
        else
            tuesPay= tuesHours*30;

        if(wedHours>8)
            wedPay=((wedHours-8)*55.50)+240;
        else
            wedPay= wedHours*30;

        if(thurHours>8)
            thurPay=((thurHours-8)*55.50)+240;
        else
            thurPay= thurHours*30;

        if(friHours>8)
            friPay=((friHours-8)*55.50)+240;
        else
            friPay= friHours*30;

        if(satHours>8)
            satPay=(((satHours-8)*55.50)+240)*1.5;
        else
            satPay= (satHours*30)*1.5;


        if(weeklyHours>40){
            overPay=(weeklyHours-40)*45; //pay if weekly hours are over 40
            weeklyPay=(sunPay + monPay + tuesPay + wedPay + thurPay + friPay + satPay + overPay); //pay including over pay
            System.out.println(twodigits.format(weeklyPay));//output
        }
        else{
            weeklyPay=(sunPay+monPay+tuesPay+wedPay+thurPay+friPay+satPay); //pay if hours is less than 40
            System.out.println(twodigits.format(weeklyPay)); //output
        }

        weekNumber++; //increments the week number
        System.out.println(); //blank line
    }