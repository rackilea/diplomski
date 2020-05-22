boolean isRunning(Process process) {
    try {
        process.exitValue();
        return false;
    } catch (Exception e) {
        return true;
    }
}