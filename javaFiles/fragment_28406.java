public static class FormatWorker extends SwingWorker<Integer, Integer> {

    private String drive;

    public FormatWorker(String drive) {
        this.drive = drive;
    }

    @Override
    protected Integer doInBackground() throws Exception {
    String[] command = {"CMD", "/C", "MyCmdCommand"};
    ProcessBuilder probuilder = new ProcessBuilder(command);
    probuilder.directory(new File(drive + ":\\"));

    Process process = probuilder.start();
    return process.waitFor();
        return 0;
    }

}