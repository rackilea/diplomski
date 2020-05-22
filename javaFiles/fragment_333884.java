class RoadInfoFactory {
  public RoadInfo getRoadInfo(String cityName, double lat, double lng) {
    String path = this.buildPathForCityName(cityName);
    String expression = this.buildExpressionForLatitute(lat);
    XPath xpath = this.initializeXPath();
    XDocument document = ...;

    String s =  (String) xpath.evaluate(expression, document, XPathConstants.STRING);
    // Or whatever you do with it..
    return new RoadInfo(s);
  }
}