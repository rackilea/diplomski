//get the input from standard in or wherever it is
Scanner scanner = new Scanner(System.in);

while(scanner.hasNext()){
    String output = "";
    String word = scanner.nextLine();
    char[] wordChars = word.toCharArray();

    for(char wordChar: wordChars){
        output = output.concat(new String(convert(wordChar)));
    }
    //do something with the output
}