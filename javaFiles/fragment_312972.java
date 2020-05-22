Struct scanSettings = Struct.builder("ScanSettings")
    .addMember("LocationTypeSpecified", 0)
    .addMember("Reserved1", 0)
    .addMember("Duration", 3.14)
    .addMember("Cycles", 1)
    .addMember("DataAvailable", false)
    .build();

ExtensionObject xo = ExtensionObject.encodeAsByteString(
    scanSettings,
    new NodeId(1, 3010),
    client.getDataTypeManager()
);

CallMethodRequest request = new CallMethodRequest(
    objectId,
    methodId,
    new Variant[]{new Variant(xo)}
);