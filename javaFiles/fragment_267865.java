final DynamicTimeSeriesCollection dataset =
    new DynamicTimeSeriesCollection(2, COUNT, new Second());
...
dataset.addSeries(gaussianData(), 0, "Human");
dataset.addSeries(gaussianData(), 1, "Alien");
...
timer = new Timer(FAST, new ActionListener() {

    // two values appended with each tick
    float[] newData = new float[2];

    @Override
    public void actionPerformed(ActionEvent e) {
        newData[0] = randomValue();
        newData[1] = randomValue();
        dataset.advanceTime();
        dataset.appendData(newData);
    }
});