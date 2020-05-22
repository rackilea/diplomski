//Search file for an array of strings. Ignores case if caseSensitive is false.
public void searchFile(String file, boolean caseSensitive, String...textToSearchFor){
    Scanner scanner = new Scanner(file);
    while(scanner.hasNextLine()){
        String originalLine = scanner.nextLine();
        String line = originalLine;
        if(!caseSensitive) line = line.toLowerCase();
        for(String searchText : textToSearchFor){
            if(!caseSensitive) searchText = searchText.toLowerCase();
            if(line.contains(searchText)){
                System.out.println(originalLine);
                break;
            }
        }
    }
    scanner.close();
}

//usage
searchFile("data.txt",true,"news","Test","bob");
searchFile("data.txt",true,new String[]{"test","News"});