Connection con = connectToDB(USERNAME, PASSWORD);
/* Note that con is a connection to database, and not the server.
if You have a connection to the server, the first command in the dumpfile should be the
USE db_name; */
String q = "";
File f = new File(sourcePath); // source path is the absolute path of dumpfile.
try {
    BufferedReader bf = new BufferedReader(new FileReader(f));
        String line = null;
        line = bf.readLine();
        while (line != null) {
            q = q + line + "\n";
            line = bf.readLine();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
// Now we have the content of the dumpfile in 'q'.
// We must separate the queries, so they can be executed. And Java Simply does this:
String[] commands = q.split(";");

try {
    Statement statement = con.createStatement();
    for (String s : commands) {
        statement.execute(s);
    }
} catch (Exception ex) {
}
closeConnection(con);