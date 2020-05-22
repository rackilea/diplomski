private void postProcessing() {
    if (process != null) {
        closeTheStream(process.getErrorStream());
        closeTheStream(process.getInputStream());
        closeTheStream(process.getOutputStream());
        process.destroy();
    }
}