public class Application {

    public static main(String[] args) {

        String data = null;
        String commandOutput = "";
        BufferedReader input = null;

        try {
            // do stuff
            data = text;
            input = // initialize buffered reader
            String line = input.readLine();
            while (line != null) {
                commandOutput += line;
                line = input.readLine();
            }
        }
        catch (SomeSpecificException ex) {
            // please handle exceptions!
        }
        catch (IOException ioex) {
            // handle IO Exceptions here
        }
        finally {               
            try {
                input.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        .
        .
        .
        String emailBody = "blah blah " + data + " blah blah " + commandOutput;
    }
}