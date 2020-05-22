public int fromScanner(Scanner scanner, String letter){
    scanner.useDelimiter(letter);
    int howMany = 0;
    while(scanner.hasNext()){
        scanner.next();
        ++howMany;
    }
    if(howMany>0)++howMany;
    return howMany;
}