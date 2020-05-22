public File findTodaysFirstFile(File directory) {
    DateFormat df = new SimpleDateFormat("MMddyyyy");
    String prefix = "ABC_DIFL_" + df.format(new Date());

    for (File current : directory.listFiles()) {
        if (current.getName().startsWith(prefix)) {
            return current;
        }
    }
    // handle failure here, throw an exception or return null as you prefer
}