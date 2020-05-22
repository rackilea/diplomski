String[] words = scanner.nextLine().split(" "); // split space between word and float number embedding

        //An Array of Float which will keep values for words.
        Float values[] = new Float[ words.length-1 ];    //  because we are not going to store word as its value.
        for( int i=1; i< words.length; i++){
            values[i-1] = Float.parseFloat(words[i]) ; }

        // Now all the values are stored in array.
        // Now store it in the Map.
        table.put(words[0], values);