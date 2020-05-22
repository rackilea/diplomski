public class UberData extends Data {
    private UberData(MyDataBuilder config) {
        ...
    }

    public static class Factory extends DataFactory {
        protected Data create(MyDataBuilder config) {
            return new UberData(config); 
        }
        protected boolean canCreate(MyDataBuilder config) {
            return config.hasFlanges() and config.getWidgetCount() < 7;
        }
    }
}