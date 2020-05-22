public void createContinents()  { 

    //  Scan the continents.txt file
    Scanner worldScan = new Scanner( new File( "continents.txt");

    //  While worldScan has a next line, run loop
    //  CHANGED: not hasNext(), but hasNextLine()
    while( worldScan.hasNextLine()) {

        //  Create a scanner for the selected line in worldScan
        String continentLine = inputTwo.nextLine();
        Scanner continentScan = new Scanner(continentLine);
        continentScan.useDelimiter(",");

        //  Grab the continent from the scanner
        String name = continentScan.next();
        System.out.println( " the continent name is" + name);

        //  Grab the armies from the scanner
        //  CHANGED: you read it out as a string, not as an int
        int bonusArmies = Integer.toString(continentScan.next());
        System.out.println(" the number of bonus armies is" + bonusArmies);

        //  Instantiate loop variable countries
        ArrayList<Country> memberCountries = new ArrayList<Country>();

        while( continentScan.hasNext()) {
            memberCountries.add(countries.get(continentScan.next()));
            System.out.println( "the member countries" + memberCountries);
        }

        //  Instantiate loop variable continent
        Continent continent = new Continent( name,  bonusArmies,  memberCountries);

        //  Add continent to the hashmap
        continents.put(name,continent);

        continentScan.close();
    }

    worldScan.close();
 }