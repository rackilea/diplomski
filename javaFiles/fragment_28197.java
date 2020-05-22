private static final String START_KEY = "F2*";
private static final String END_KEY = "*K";
List<String> substrings = new ArrayList<String>();

private void processString(String s){
    if(s.indexof(START_KEY) == -1){
        return;
    }

    //Offset target string by number of char in START_KEY
    substrings.add(s.substr(s.indexof(START_KEY) + 3, s.indexOf(END_KEY)));

    //Recursive call on left over char if any exist
    try{
        processString(s.substr(endKey + 2);  
    } catch (IndexOutOfBoundsException e) {
        //ignore - if no string left call should end
    }
}