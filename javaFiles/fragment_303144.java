words += keys.nextLine(); //Stores the lines of text
if(words.endsWith(words.substring(words.lastIndexOf(" ")+1))) { //detect last word in sentence 
        words += '\n'; //after last word, append newline
}

...

for(int i = 1; i <= multiplier; i++) {
        outputFile.print(words); //change this to print instead of println
}