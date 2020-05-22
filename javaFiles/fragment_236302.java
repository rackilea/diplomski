// inner class
class TextChanger implements Runnable {
    private final String message;

    public TextChanger(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        loadingMessage1.append(message);
    }

}