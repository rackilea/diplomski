String word ="hello";
    Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();

    //inserting letters into table
    int x;
    for (char letter : word.toCharArray()) {

        //letter is already in table
        if (table.containsKey(letter)) {
            x = table.get(letter)+1;
        }
        //if letter is not already in table
        else {
            x=1;
        }
        table.put(letter, x);
    }
    System.out.println( table);