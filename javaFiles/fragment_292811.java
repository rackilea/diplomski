/**
This method adds the two ArrayLists together into a new ArrayList, then returns the  
values concatenated into one line. 
*/
public ArrayList<String> getAllIncidentsArray() {

    for (int i = 0; i < datesSmoked.size(); i++) {
        allIncidents.add(getDates().get(i) + ", " + locationsSmoked.get(i));
    }

return allIncidents;
}