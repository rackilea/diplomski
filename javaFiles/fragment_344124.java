public class DefaultHeartMonitorModel implements HeartMonitorModel {

    private double phase = 0;
    private int numPoints = 200;

    @Override
    public List[] getSineData() {
        phase += 2 * Math.PI * 2 / 20.0;
        List<Double> xData = new ArrayList<>(100);
        List<Double> yData = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            double radians = phase + (2 * Math.PI / 100 * i);
            xData.add(radians);
            yData.add(Math.sin(radians));
        }
        return new List[]{xData, yData};
    }

    @Override
    public List getWalkData() {
        List<Double> data = new ArrayList<>(numPoints);
        data.add(0.0);
        for (int i = 1; i < numPoints; i++) {
            double last = data.get(i - 1);
            data.add(last + + Math.random() - .5);
        }
        return data;
    }

}