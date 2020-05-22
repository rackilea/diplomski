ArrayList<Double> xPoints = new ArrayList<Double>();
ArrayList<Double> yPoints = new ArrayList<Double>();

for (each line of the file){
    String line = file.readLine();
    String[] splitLine = line.split(",");

    double xValue = Double.parseDouble(splitLine[0]);
    double yValue = Double.parseDouble(splitLine[1]);

    xPoints.add(xValue);
    yPoints.add(yValue);
}