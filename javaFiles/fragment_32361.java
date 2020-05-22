XmlDynamic example = new XmlDynamic(xmlStringOrReaderOrInputSourceEtc);

String target = "android";
Map<String, String> keyTypeToValue = example.get("object")
    .get(target)
    .get("activity|keys")
    .children()
    .collect(toMap(key -> key.get("type").asString(), key -> key.get("value").asString()));
// {name=signIn, index=0}