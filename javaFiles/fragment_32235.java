// package declaration
// imports 
public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            String query = "select FOO from BLAH a where a.BAZ = ?";
            Connection connection = ...
            PreparedStatement statement = connection.createPreparedStatement(query);
            statement.setString(1, args[0]);
            ResultSet rs = statement.execute();
            // etcetera
        } else {
            // report missing command line argument.
        }
    }
}