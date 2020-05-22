private void makeRGB(Circle c) {
    makeRGB(c::getFill, c:setFill);
}

private void makeRGB(Scene s) {
    makeRGB(s::getFill, s:setFill);
}

private void makeRGB(Supplier<Paint> currentFill, Consumer<Paint> updater) {
    Timer t = new Timer();
    t.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            if(currentFill.get() == Color.RED) {
                updater.accept(Color.GREEN);
            } else if (currentFill.get() == Color.GREEN) {
                updater.accept(Color.BLUE);
            } else {
                updater.accept(Color.RED);
            }
        }
    },0, RGB_CHANGE_PERIOD);
}