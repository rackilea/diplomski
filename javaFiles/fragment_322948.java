List<SomeObj> yList = filter(having(on(SomeObj.class).getIndicator(), equalTo("Y")), listOfSomeObjs);
List<SomeObj> nList = filter(having(on(SomeObj.class).getIndicator(), equalTo("N")), listOfSomeObjs);
List<SomeObj> dList = filter(having(on(SomeObj.class).getIndicator(), not(equalTo("Y"))).and(having(on(SomeObj.class).getIndicator(), not(equalTo("N")))), listOfSomeObjs);

Map<String, List<SomeObj>> map = new HashMap<>();
map.put("Y", yList);
map.put("N", nList);
map.put("D", dList);