private class CsvImporter extends SwingWorker<Boolean, Void> {

        public boolean readCsv(File file) throws IOException {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                displayLabel.setText("..still reading");
                if (isCancelled())
                    return false; // this cancels after the import, but I want
                                    // to cancel during the import...
            }
            reader.close();
            displayLabel.setText("..actually done.");
            return true; // read complete
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            long t0 = System.currentTimeMillis();
            displayLabel.setText("starting execution...");
            displayLabel.setText("..importing csv");
            CsvImporter csvImporter = new CsvImporter();
            boolean readStatus = csvImporter.readCsv(csvIn);
            if (readStatus) {
                long t1 = System.currentTimeMillis();
                displayLabel.setText("csv imported in " + String.format("%,d", t1 - t0) + " ms");
                for (short i = 1; i <= 10; i++) {
                    if (isCancelled())
                        return false; // this works fine as it is called every second
                    TimeUnit.SECONDS.sleep(1);
                    displayLabel.setText("counter: " + i);
                }
            }
            return readStatus;
        }
    }