List<LargeNumber> firstList = new ArrayList<>();
List<LargeNumber> secondList = new ArrayList<>();
try{
    theFile = new FileReader(args[0]);
    inFile = new BufferedReader(theFile);
    while(inFile.ready()){
        String firstLine = getNonEmptyLine(inFile);
        if(firstLine.isEmpty()) break;
        String secondLine = getNonEmptyLine(inFile);
        if(secondLine.isEmpty()) break;
        firstList.add(makeLargeNumber(firstLine));
        secondList.add(makeLargeNumber(secondLine));
    }
}
catch(Exception e){
    System.out.println(e);
}