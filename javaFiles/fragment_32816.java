private static void parseXml(String xml) {
    Document doc = Jsoup.parse(xml);
    StringBuilder queryBuilder;
    StringBuilder columnNames;
    StringBuilder values;

    for (Element row : doc.select("row")) {   
        // Start the query   
        queryBuilder = new StringBuilder("insert into customer(");
        columnNames = new StringBuilder();
        values = new StringBuilder();

        for (int x = 0; x < row.children().size(); x++) {

            // Append the column name and it's value 
            columnNames.append(row.children().get(x).tagName());
            values.append(row.children().get(x).text());

            if (x != row.children().size() - 1) {
                // If this is not the last item, append a comma
                columnNames.append(",");
                values.append(",");
            }
            else {
                // Otherwise, add the closing paranthesis
                columnNames.append(")");
                values.append(")");
            }                                
        }

        // Add the column names and values to the query
        queryBuilder.append(columnNames);
        queryBuilder.append(" values(");
        queryBuilder.append(values);

        // Print the query
        System.out.println(queryBuilder);
    }
}