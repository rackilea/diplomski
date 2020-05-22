//Variables
UnfoldingMap map;
List<Marker>countryMarkers;

HashMap<String, DataEntry> dataEntriesMap;

//Core methods...
void setup() {
  size(800, 600);
  smooth();
  map = new UnfoldingMap(this);
  MapUtils.createDefaultEventDispatcher(this, map);

  //Read in GeoJSON File - Countries
  List<Feature> countries = GeoJSONReader.loadData(this, "countries.geo.json");
  countryMarkers = MapUtils.createSimpleMarkers(countries);
  map.addMarkers(countryMarkers);//Add the countries to the map

  //External Data source - CSV file
}


void draw() {
  map.draw();
}

public class DataEntry {
    String countryName;
    String id;
    Integer year;
    Float value;
}