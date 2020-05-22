@Override
public void start(Stage primaryStage) {
    final Queue<String> words = new LinkedList<>(Arrays.asList(
            "Hello",
            "World",
            "foo",
            "bar"
    ));
    final Pane wordsPane = new Pane();
    wordsPane.setPrefSize(800, 400);
    final long wordDelay = 500_000_000L; // 500 ms
    final long fallDuration = 12_000_000_000L; // 12 s

    AnimationTimer animation = new AnimationTimer() {

        private long lastWordAdd = Long.MIN_VALUE; // never added a word before
        private final Map<Text, Long> nodes = new LinkedHashMap<>();

        private double nextX = 0;

        private void assignXPosition(Text text) {
            text.setTranslateX(nextX);
            nextX += text.getBoundsInLocal().getWidth();
        }

        @Override
        public void handle(long now) {
            // updates & cleanup
            long deletionLimit = now - fallDuration;
            for (Iterator<Map.Entry<Text, Long>> iter = nodes.entrySet().iterator(); iter.hasNext();) {
                Map.Entry<Text, Long> entry = iter.next();
                final Text text = entry.getKey();
                final long startTime = entry.getValue();
                if (startTime < deletionLimit) {
                    // delete old word
                    iter.remove();
                    wordsPane.getChildren().remove(text);
                } else {
                    // update existing word
                    double factor = ((double) (now - startTime)) / fallDuration;
                    Bounds bounds = text.getBoundsInLocal();
                    text.setTranslateY((wordsPane.getHeight() + bounds.getHeight()) * factor - bounds.getMaxY());
                }
            }

            if (words.isEmpty()) {
                if (nodes.isEmpty()) {
                    stop(); // end animation since there are no more words
                }
            } else if (lastWordAdd + wordDelay <= now) {
                lastWordAdd = now;
                // add new word
                Text text = new Text(words.remove());
                wordsPane.getChildren().add(text);
                assignXPosition(text);
                text.setTranslateY(-text.getBoundsInLocal().getMaxY());
                nodes.put(text, now);
            }

        }
    };
    animation.start();

    Scene scene = new Scene(wordsPane);

    primaryStage.setScene(scene);
    primaryStage.show();
}