String species1;
    switch(species) { 
        case "help": System.out.println("Anglewing: The Anglewing is a smaller dragon with golden brown oddly angled wings and bright yellow spots.");
        System.out.println("");
        System.out.println("Regal Copper: This heavyweight dragon exceeds all known breeds in sheer size (30–50 tons). Regal Coppers have vivid colorations ranging from red to yellow, and are very far-sighted.");
      ...
        System.out.println("");
        Scanner dragonSpecies1 = new Scanner(System.in);            
        System.out.println("What species of Dragon would you like to raise?");  

        species1 = dragonSpecies1.nextLine();
        break;
    default: 
        species1 = species;
        break;