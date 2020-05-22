List<Point> points = new ArrayList<>();
Scanner scanner = new Scanner( /* whatever your input source is */ );
String pointRegex = "\\(\\d,\\d\\)"; //looks for something like "(#,#)"
while(!scanner.hasNext(pointRegex)){
    String pointText = scanner.next(pointRegex); //For example, "(5,4)"
    Point point = getPointFromText(pointText); //turns a string into a point
    points.add(point);
}