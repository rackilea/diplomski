@Override
protected void done() {
    button.setEnabled(true);
    try {
        if (!isCancelled()) {
            get();
            System.out.println("File has been downloaded successfully!");
            return;
        }
    } catch (InterruptedException x) {
        x.printStackTrace();
    } catch (ExecutionException x) {
        // This should print an IllegalArgumentException
        // if me theory (explained below) is correct.
        x.getCause().printStackTrace();
    }
    System.out.println("There was an error in downloading the file.");
}