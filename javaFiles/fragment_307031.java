public class BasicBoltAdapter implements IMyBasicBolt {

    private IBasicBolt basicBolt;

    public BasicBoltAdapter(IBasicBolt basicBolt) {
        this.basicBolt = basicBolt;
    }

    @Override
    public void prepare(Map<String, Object> stormConf, String other) {
        basicBolt.prepare(stormConf, other);
    }    

}