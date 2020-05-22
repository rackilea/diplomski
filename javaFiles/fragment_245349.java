CamundaInputParameter headers = model.newInstance(CamundaInputParameter.class);
    headers.setCamundaName("headers");

    CamundaMap map = model.newInstance(CamundaMap.class);
    CamundaEntry entry = model.newInstance(CamundaEntry.class);
    entry.setCamundaKey("Content-Type");
    entry.setTextContent("application/json");
    map.addChildElement(entry);
    //headers.addChildElement(map); does not work
    headers.getDomElement().appendChild(map.getDomElement()); // works