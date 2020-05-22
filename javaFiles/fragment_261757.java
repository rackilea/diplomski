JSch.setLogger(new com.jcraft.jsch.Logger() {
    Path path = Paths.get("C:\\path\\jsch.log");
    @Override
    public boolean isEnabled(int level){
        return true;
    }
    public void log(int level, String message){
        try {
            StandardOpenOption option =
               !Files.exists(path) ? StandardOpenOption.CREATE : StandardOpenOption.APPEND;
            Files.write(path, java.util.Arrays.asList(message), option);
        } catch (IOException e) {
            System.err.println(message);
        }
    }
});