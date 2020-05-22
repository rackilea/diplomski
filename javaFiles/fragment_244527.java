SimpleDateFormat photoFormat = new SimpleDateFormat("ddMMyy-hhmmss");

        // create formating for date
        SimpleDateFormat sdf = new SimpleDateFormat("MMMddyy-hhmmss");
        /*
         * This sections checks the phone to see if there is a SD card. if
         * there is an SD card, a directory is created on the SD card to
         * store the test log results. If there is not a SD card, then the
         * directory is created on the phones internal hard drive
         */
        // if there is no SD card
        if (Environment.getExternalStorageState() == null) {
            directory = new File(Environment.getDataDirectory()
                    + "/RobotiumTestLog/");
            photoDirectory = new File(Environment.getDataDirectory()
                    + "/Robotium-Screenshots/");

            // if no directory exists, create new directory
            if (!directory.exists()) {
                directory.mkdir();
            }

            // if phone DOES have sd card
        } else if (Environment.getExternalStorageState() != null) {
            // search for directory on SD card
            directory = new File(Environment.getExternalStorageDirectory()
                    + "/RobotiumTestLog/");
            photoDirectory = new File(
                    Environment.getExternalStorageDirectory()
                            + "/Robotium-Screenshots/");

            // if no directory exists, create new directory to store test
            // results
            if (!directory.exists()) {
                directory.mkdir();
            }
        }// end of SD card checking

        /*
         * Below is where the name of the test log is created.This can be
         * changed for any other test methods
         */
        String fileName = "TravelTestResults.csv";

        /*
         * Checks for existing test logs, and if they exist, they are
         * deleted, creating a new test log for each testing method
         */
        File logResults = new File(directory, fileName);
        if (logResults.exists()) {
            logResults.delete();
        }
        if (!logResults.exists()) {
            logResults.createNewFile();
        }
        /*
         * This creates the writing stream to log the test results This
         * stream MUST be closed, using bw.close(), for the test results to
         * show on the log. If the stream is not closed, when you open the
         * text file that the results are stored in, the page will be blank.
         */
        bw = new BufferedWriter(new FileWriter(logResults, true));
        bw.write("Test Run, Test Result, Comments \"\n\"");
                    bw.close();