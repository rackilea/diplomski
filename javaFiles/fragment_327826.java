You should initialise driver before entering into loop, currently you are initialising driver in loop thus causing driver to open multiple windows, also close firefox only after completing loop else you may face problem in next iteration of loop.

    Change it like this:

     //Initialise driver here and then go to loop:
            WebDriver driver = new FirefoxDriver();  
             String appUrl = "https://accounts.google.com";
             driver.get(appUrl);
             driver.manage().window().maximize();   


     while ((nextLine = reader.readNext())!= null){

            String user_name = nextLine[0];
            String pass_word = nextLine[1];

            System.out.println("Username: " + user_name);
            System.out.println("Password: " + pass_word);


    }

   System.exit(0);