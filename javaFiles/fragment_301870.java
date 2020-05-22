//given wordList as the word list
//given startChar as the character to search for in the form of a *String* not char
for (String element : wordList){
    if (element.startsWith(startChar)){
        System.out.println(element);
    }
}