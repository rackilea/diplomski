public String[] GetDevices(){
    List<String> Devices = new ArrayList<String>();
    String query = "SELECT * FROM devices";
    try {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            Devices.add(resultSet.getString(1));
            Devices.add(resultSet.getString(2));
        }
    } catch (SQLException ex) {
        System.out.println("\nNão foi possivel ler os dispositivos do database");
        System.out.print(ex.getMessage());

    }
    return Devices.toArray(new String[0]);
}