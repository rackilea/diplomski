private void createFile() throws Exception {
    File currentDir = new File(Preferences.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
    prefs = new File(currentDir.getParentFile().getAbsoluteFile() + "/hackemos-prefs.txt");
    if(!prefs.exists()) {
        prefs.createNewFile();

        String[] defaults = {
                "9", // number of items
                "100", // correct limit
                "0", // amount to get wrong
                "75", // delay, in ms
                "456,278", // default mouse position for start button
                "653,476", // default mouse position for copying text
                "686,615", // default mouse position for the text box
                "150,100", // Copy drag range
                "0" // mac mode, 1 = enabled
        };

        write(defaults);
    }
}