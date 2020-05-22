String pathToFile = "data.txt";
String textToSearchFor = "news";
Scanner scanner = new Scanner(pathToFile);
while(scanner.hasNextLine()){
    String line = scanner.nextLine();
    if(line.contains(textToSearchFor)){
        System.out.println(line);
    }
}
scanner.close();