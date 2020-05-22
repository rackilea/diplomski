AnimationTimer timer = new AnimationTimer() {

    private int updates = 0 ;
    @Override
    public void handle(long now) {
        List<String> newStrings = new ArrayList<>();
        updates += textQueue.drainTo(newStrings);
        StringBuilder sb = new StringBuilder();
        newStrings.forEach(sb::append);
        resultsTA.appendText(sb.toString());
        if (updates >= iterations) {
            stop();
        }
    }
};

timer.play();