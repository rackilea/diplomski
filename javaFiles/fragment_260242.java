class Configuration {

  @XmlElementWrapper(name = "things")
  @XmlElement(name = "thing")
  List<Thing> things;
}

class Thing {
  String name;
  String value;
}