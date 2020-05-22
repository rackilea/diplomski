public void readFile(String file) throws FileNotFoundException{
    File myFile = new File("Cars.txt");
    Scanner scanner = new Scanner(myFile);
    String line = scanner.nextLine();
    String delimiter = ",";
    StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
    int tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens, should yield 4 
    while(tokenizer.hasMoreTokens()){ 
        if(tokenCount != 4){ //if there isn't exactly 4 tokens, print the rest to the console
            System.out.println(tokenizer.toString());
        }
        else {
            //newCar(Make, Model, Year, Mileage);
            Car newCar = new Car(tokenizer.nextToken(), tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            unsortedList.add(newCar);
            sortedList.addAll(unsortedList);
        }
        if(scanner.hasNextLine()){
            line = scanner.nextLine();
            tokenizer = new StringTokenizer(line, delimiter);
            tokenCount = new StringTokenizer(line, ",").countTokens(); //counts the tokens, should yield 4 
        }
        else{
            break;
        }
    }
    scanner.close();
    selectionSort(sortedList);
}