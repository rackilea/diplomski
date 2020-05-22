ArrayList<String> finalPhrases = new ArrayList<String>();
switch (response){
//TODO: FIX
    case 2: 
        finalPhrases = modeOne(inputScanner, patternScanner);
        break;
    case 1: 
        finalPhrases = modeTwo(inputScanner, patternScanner);
        break;
    case 0:
        finalPhrases = modeThree(inputScanner, patternScanner);
        break;
    default:
        // TODO add code for value other than 0, 1 or 2
        break;
}   

System.out.println(finalPhrases);