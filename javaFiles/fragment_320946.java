public class MyMap {

    Map<String, String> map;

    public MyMap(MyMapBuilder builder) {
        this.map = builder.map;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public static class MyMapBuilder {

        Map<String, String> map;

        public MyMapBuilder() {
            this.map = new HashMap<String,String>();
        }

        public MyMapBuilder doOperationOne() {
            new OperationOne().run(map);
            return this;
        }

        public MyMapBuilder doOperationTwo() {
            new OperationTwo().run(map);
            return this;
        }

        public MyMapBuilder doOperationThree() {
            new OperationThree().run(map);
            return this;
        }

        public MyMap build() {
            return new MyMap(this);
        }

    }
}