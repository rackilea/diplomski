String ExecutionPath = "pathTo/run.vbs";
final Process process = Runtime.getRuntime().exec("wscript " + ExecutionPath);

Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    public void run() {
        process.destroy();
    }
}));
process.waitFor();