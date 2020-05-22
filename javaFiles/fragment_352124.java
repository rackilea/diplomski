public List<Employee> filter(empList, queryWords){
    List<Employee> result = new ArrayList<Employee>();

    // look at each employee in the list
    for(Employee employee : empList){

        // look at each query string
        for(String queryWord : queryWords){

        // if any of the employee fields matches the query word, 
        // add it to our list and move to next employee
        if(employee.name.equals(queryWord) ||
            employee.gender.equals(queryWord) ||
            employee.id.toString().equals(queryWord) ||
            isQueryInList(queryWord, employee.projects)) {
                // add it to your results
                result.add(employee);

                // quit looking at the rest of the queryWords, 
                // we found one, thats enough, move on to the next employee
                break; 
            }
        }
    }

    return result;
}

private boolean IsQueryInList(String queryWord, List<String> items){
    //check each item in the list to see if it matches the queryWord
    for(String item : items){
        if(queryWord.equals(item)) {
            return true;
        }
    }

    //if we didn't find any item that matches, return false
    return false;
}