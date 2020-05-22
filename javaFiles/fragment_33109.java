public class DataLoader extends Service<Boolean> {

    int total;

    /**
     * Constructor
     */
    public DataLoader() {

        // if succeeded
        setOnSucceeded(s -> {
            //code if Service succeeds
        });

        // if failed
        setOnFailed(fail -> {
            //code it Service fails
        });

        //if canceled
        setOnCancelled(cancelled->{
            //code if Service get's cancelled
        });
    }

    @Override
    protected Task<Boolean> createTask() {
        return new Task<Boolean>() {
            @Override
            protected Void call() throws Exception {

                // -------------------------- Load all the libraries
                try (ResultSet resultSet = connection1.createStatement().executeQuery("SELECT* FROM LIBRARIES;");
                        ResultSet dbCounter = connection1.createStatement()
                                .executeQuery("SELECT COUNT(*) FROM LIBRARIES;");) {

                    total = dbCounter.getInt(1);
                    Main.logger.info("Uploading libraries....");

                    // Refresh the text
                    Platform.runLater(() -> Main.updateScreen.label.setText("Uploading Libraries..."));
                    updateProgress(1, 2);

                    // Load all the libraries
                    while (resultSet.next()) {

                        Library library = new Library(resultSet.getString("NAME"), resultSet.getString("TABLENAME"),
                                resultSet.getDouble("STARS"), resultSet.getString("DATECREATED"),
                                resultSet.getString("TIMECREATED"), resultSet.getString("DESCRIPTION"),
                                resultSet.getInt("SAVEMODE"), resultSet.getInt("POSITION"),
                                resultSet.getString("LIBRARYIMAGE"), resultSet.getBoolean("OPENED"));

                        //Using Platform Later to Modify JavaFX Nodes
                        Platform.runLater(()->{
                           //code here
                        });

                        updateProgress(resultSet.getRow(), total);
                    }

                } catch (Exception ex) {
                    Main.logger.log(Level.SEVERE, "", ex);
                    return false //something bad happened
                }

                return true;
            }
        };
    }

}