int playerCharacter;

    Map<Integer, String> characters = new HashMap<Integer, String>();
    characters.put(1, "Fighter");
    characters.put(2, "Mage");
    characters.put(3, "Rogue");        

    playerCharacter = 2; //This is what you get from input

    System.out.println("You are: " + characters.get(playerCharacter));