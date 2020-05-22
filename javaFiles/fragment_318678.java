@Override
public void receivePrizes(ArrayList<String> prizes) {
    // do update on the javafx application thread
    Platform.runLater(() -> {
        prizeList.getItems().addAll(prizes);
    });
}