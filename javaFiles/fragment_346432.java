enum Range {
    LIGHT, MODERATE, VIGOROUS, UNKNOWN
}

NavigableMap<Double, Range> map = new TreeMap<>();

map.put(Double.NEGATIVE_INFINITY, Range.UNKNOWN);
map.put(0D, Range.LIGHT);
map.put(3D, Range.MODERATE);
map.put(6D, Range.VIGOROUS);

System.out.println(map.floorEntry(4D).getValue());