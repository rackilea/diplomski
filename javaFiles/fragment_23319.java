File f = new File(FILE_path);
        if (f.exists() && f.canRead()) {
            try {
                //Do something
            } catch (IOException e) {
                JOptionPane.showMessageDialog (null, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
                LOGGER.error("Error message: " + e.getMessage());
            }
        } else {
            LOGGER.error("File does not exist or it cannot be read.");
        }