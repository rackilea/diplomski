Iterable<HashMap<String, EntityProperty>> results =
        cloudTable.execute(query, propertyResolver);

int counter;
if (results == null) {
    System.out.println("No files processed");
    exit_code = "exit_code=1";
} else {
    counter = 0;
    for (HashMap<String, EntityProperty> entity : results) {
        // don't know how to start the loop here 
        counter++;
    }
    //int size = results.size();
}