@Override
public ArrayList<Object> getExpenses() {
    ArrayList<Object> expenses = new ArrayList<Object>();
    try {
        Statement stmt = myConnection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM expenses");
        while(result.next()) {

            expenses.add(new Integer(result.getInt(1)));

            expenses.add(result.getString(2));
            expenses.add(new Integer(result.getInt(3)));
            expenses.add(result.getDouble(4));
        }
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return expenses;
}