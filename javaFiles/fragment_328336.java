ArrayList<Point> points = new ArrayList<Point>();

for (each line of the file){
    String line = file.readLine();
    String[] splitLine = line.split(",");

    double xValue = Double.parseDouble(splitLine[0]);
    double yValue = Double.parseDouble(splitLine[1]);

    points.add(new Point(xValue,yValue));
}