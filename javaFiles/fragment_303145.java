while(keys.hasNextLine()) {
    if (keys.hasNextInt()) { //validation that will read lines until it see's an integer and stores that number
        multiplier = keys.nextInt(); //Stores the number from text
    } else {
        words += keys.nextLine();//Stores the lines of text
        if(words.endsWith(words.substring(words.lastIndexOf(" ")+1))) {
            words += '\n';
        }
    }
}