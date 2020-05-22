@override
protected void process(List<String> wordsToPrint) {
    for (String text: wordsToPrint) {
        mainWindowTextArea.append(text + "\n");
    }
}

@override
protected void done() {
    publish("\nDone");
    try {
        get();
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
}