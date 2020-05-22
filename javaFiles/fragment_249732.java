public static ArrayList<String> filteredArrayList(HashMap<String, Boolean> filters){

    ArrayList<String> filteredArrayList = fullList(); //Note, that fullList method already creates and returns array, so you don't need to create it before calling this method.

    Iterator<String> i = filteredArrayList.iterator();
    while (i.hasNext()) {
        String s = i.next();

        if(!(filters.get("sometextStatus")) && (s.toLowerCase().trim().contains("sometext".trim().toLowerCase()))){
                i.remove();
                continue; //We removed current element, so next if check might potentially removed already removed element!
        }

        if(!(filters.get("120Status")) && (s.toLowerCase().trim().contains("120".trim().toLowerCase()))){
                i.remove();
                continue; //Maybe a programmer will decide to copy-paste if checks, so it is safer to do so with continue.
        }
    }
}