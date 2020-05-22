private void searchContact() {
    assert(!(emailRecords == null || emailRecords.isEmpty()));// :P
    //initially copy all
    ArrayList<String> searchRecords = new ArrayList<>(emailRecords);
    //prepare scanner
    Scanner search = new Scanner(System.in);
    //initialize query
    String query = "";
    //loop:
    while (searchRecords.size() > 1) {
        System.out.println("Please enter the first letter of the email you're trying to find.");
        //read from input
        query += search.nextLine();
        //iterate through remaining searchRecords
        for (Iterator<String> it = searchRecords.iterator(); it.hasNext();) {
            final String entry = it.next();
            if (!entry.startsWith(query)) {//...conditionally
                it.remove();//..remove (from searchRecords)
            }
        }
    }
    //print output - first/last of searchRecords
    if (!searchRecords.isEmpty())
        System.out.println(searchRecords.get(0));
    else
        System.out.println("No record found.");
}