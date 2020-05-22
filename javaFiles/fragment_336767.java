newArc = addArc(places.get(src), transitions.get(dest));
if (label != null) {        
    AttributeMap amap = newArc.getAttributeMap();
    amap.put(AttributeMap.LABEL, "Hello world");
    amap.put(AttributeMap.SHOWLABEL, true);
    amap.put(AttributeMap.LABELALONGEDGE, true);
}