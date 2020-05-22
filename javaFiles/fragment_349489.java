public void run(){
    do {
        try {
            String msg = getFromServer.readUTF(); // <--- freeze GUI
            Platform.runLater(() -> chatWindow.appendText(msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    } while (true);
}