// create the map
Map<XYCoord, List<MyObject>> objectsOnThePlan = new HashMap<>();

// populate it 
objectsOnThePlan.put(new XYCoord(1O, 30), new ArrayList<>(Arrays.asList(fooObj, fooObj2, fooObj3)));
objectsOnThePlan.put(new XYCoord(40, 20), new ArrayList<>(Arrays.asList(barObj, barObj2, barObj3)));  

// retrieve List from a specific coordinate
List<MyObject> listFrom10x30y = objectsOnThePlan.get(new XYCoord(10, 30));