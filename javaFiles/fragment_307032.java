IBasicBolt basicBolt = new IBasicBolt() {

    @Override
    public void prepare(Map stormConf, String other) {
        System.out.println(stormConf.toString() + " " + other);
    }
};
Map<String, Object> map = new HashMap<>();
map.put("MapKeyTest", new Object());
IMyBasicBolt myBasicBolt = new BasicBoltAdapter(basicBolt);
myBasicBolt.prepare(map, "Test");