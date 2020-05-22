class Info {
public RoadInfo(String cityName, double lat, double lng) throws FileNotFoundException, SAXException, IOException, XPathExpressionException {
    // TODO Auto-generated constructor stub
    this.cityname = cityName;
    this.lat = lat;
    this.lng = lng;

    this.path = "c:"+File.separatorChar+this.cityname+".xml";

    System.out.println(path);

    this.initXPath();
    this.method1()
    this.method2()
    ..

    this.expr = "//node[@lat='"+this.lat+"'"+"]/following-sibling::tag[1]/@v";
    this.xPath.compile(this.expr);
    String s = (String) this.xPath.evaluate(this.expr, this.document, XPathConstants.STRING);
    System.out.println(s);
}