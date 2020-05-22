static List<String > currentElections = new ArrayList<String >();

public String electionServer(String input) {
    // save currently running elections    
    currentElections.add( input );
}