while (scanner.hasNextLine()){
    InputLine2 = scanner.nextLine();
    String[] InArray = InputLine2.split (",");
    for (int x=0; x< InArray.length; x++){
       junior [Rowc2][0] = InArray[x]; // even this isn't useful (why explained further below)
    }
    Rowc2++; // this causes the Exception
}