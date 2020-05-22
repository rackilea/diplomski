FileInputStream fstream = new FileInputStream("PhoneFile.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a first name");
    name = input.nextLine();

    String[] line;
    String part1, part2, part3;

    //Read File Line By Line
    while ((strLine= br.readLine()) != null)    
    {
        line = strLine.split(" ");
        part1 = line[0]; 
        part2 = line[1];
        part3 = line[2];

        if(name.equals(part1)) 
        {
            System.out.print("\n" + part2 + " " + part3);
        }


    }