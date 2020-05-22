//first create a loop tho go through all objects until found or no more objects
while (index < dictionary.length && !found) {

 //check if Dictionary is a thesaurus or bilingual Dictionary
 if (dictionary[index] instanceof Bilingual) {

    //downcast that object
    Bilingual aDictionary = (Bilingual)dictionary[index];

   //get the array of instance variables for that a specific object at the index
    String[] words = aDictionary.getAllWords();

    int x = 0;

    //now go through the array & check if it contains the word
    while(x < words.length && !found) {
       if (words[x].equalsIgnoreCase(word)) {
          found = true;
       }
       else {
          //go to next word 
          x++;
       }
    }
 }

    //go to next dictionary object
    index++;

}                 
return found;