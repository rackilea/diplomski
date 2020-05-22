public class RowFinder {
    boolean autoCommit;

    public RowFinder(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public static void main(String[] args) {
        RowFinder rowFinder = new RowFinder(false);
        rowFinder.findRows("YOUR_TABLE_NAME", "PRIMARY_KEY_FIELD_NAME", "OLD_ID", "NEW_ID_FOR_CHILDREN");
    }

    public void findRows(String tableName, String columnName, String oldId, String newId) {

        Connection connection = null;
        java.sql.Statement statement = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin@DB_IP_ADDRESS:1521:SID", "USER", "PASS");
            connection.setAutoCommit(autoCommit);
            statement = connection.createStatement();

            System.out.println(String.format("\nTrying to Delete %s with Old ID: '%s' and Update Children with New ID: '%s'", tableName, oldId, newId));

            boolean flag = true;
            long counter = 1;
            while (flag) {

                try {
                    String deleteQuery = String.format("delete from %s where %s = %s", tableName, columnName, oldId);
                    statement.executeUpdate(deleteQuery);
                    flag = false;
                } catch (SQLException e) {

                    String errorMessage = e.getMessage();
                    //TRYING TO FIND THE CONSTRAINT NAME FROM ERROR - YOU CAN CHANGE IT ACCORDING TO YOUR PROJECT SETTINGS
                    Pattern pattern = Pattern.compile("\\(PROJECT_NAME\\.(.*)\\)");
                    Matcher matcher = pattern.matcher(errorMessage);
                    String referenceName;
                    if (matcher.find()) {
                        referenceName = matcher.group(1);
                        String constraintTableQuery = String.format("SELECT ucc.table_name,ucc.column_name FROM user_cons_columns ucc WHERE ucc.constraint_name = '%s'", referenceName);
                        try {
                            ResultSet resultSet = statement.executeQuery(constraintTableQuery);
                            resultSet.next();
                            String constraintTableName = resultSet.getString(1);
                            String constraintColumnName = resultSet.getString(2);
                            String updateQuery = String.format("UPDATE %s SET %s = '%s' WHERE %s = '%s'", constraintTableName, constraintColumnName, newId, constraintColumnName, oldId);
                            statement.executeUpdate(updateQuery);
                            System.out.println(String.format("%s. Updated Child Located at : %s => %s",counter++,constraintTableName,constraintColumnName));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        System.out.println("Matcher didn't find anything... Exiting...");

                        if (autoCommit)
                            connection.commit();
                        else
                            connection.rollback();

                        statement.close();
                        connection.close();
                        System.exit(0);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (autoCommit){                
                    System.out.println("Deleted the Record and Changed its Children.");
                    connection.commit();    
                }
                else{
                    System.out.println("Rolling Back Changes...");
                    connection.rollback();
                }

                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}