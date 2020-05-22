//Create a new scanner pointed at the file in question
    Scanner scanner= new Scanner(new File ("C:\\Path\\To\\something.txt"));

    //Create a placeholder for the currently known biggest integer
    int biggest = 0;

    while (scanner.hasNextLine()) {
        String s = scanner.nextLine();

        //This line assumes that the third word separated by spaces is an 
        //    integer and copies it to the `cndt` variable
        int cndt = Integer.parseInt(s.split(" ")[2]);

        //If cndt is bigger than the biggest recorded integer so far then
        //    copy that as the new biggest integer
        biggest = cndt > biggest ? cndt : biggest;
    }

    //Voila
    System.out.println("Biggest: " + biggest);