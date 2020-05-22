// package declaration
// imports 
public class Main {
    public static void main(String[] args) {
        if (args.length >= 1) {
            String query = "select FOO from BLAH a where a.BAZ = '" 
                + args[0] + "'";
            Connection connection = ...
            Statement statement = connection.createStatement();
            ResultSet rs = statement.execute(query);
            // etcetera
        } else {
            // report missing command line argument.
        }
    }
}