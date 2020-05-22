for (String line = bReader.readLine(); line != null; line = bReader.readLine()) {   

          //Splitting the content of comma delimited file
    String data[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

         //Iterating through the file and updating the table.
    statement = connect.prepareStatement(psQuery);
    for (int i =0; i < data.length;i++) {
        temp =  data[i];
        temp = temp.replaceAll("\"", "");
        statement.setString(i+1, temp);
    }
    statement.executeUpdate();
}