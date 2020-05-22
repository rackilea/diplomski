private static class TestObject {

    String id, name, version;

    public TestObject(String id, String name, String version) {
        super();
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}

public static void main(String[] args) {

    List<TestObject> pgetName = new ArrayList<TestObject>() {
        @Override
        public int indexOf(Object o) {
            if (o == null || this.isEmpty()) {
                return -1;
            }
            int counter=0;
            for (TestObject current : this) {
                if (o.equals(current.getName())) {
                    return counter;
                }
                counter++;
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            if (o == null || this.isEmpty()) {
                return -1;
            }
            for (int i=this.size()-1; i>=0;i--) {
                TestObject current = get(i);
                if (o.equals(current.getName())) {
                    return i;
                }
            }
            return -1;
        }
    };
    pgetName.add(new TestObject("1", "name1", "ver1"));
    pgetName.add(new TestObject("2", "name2", "ver2"));
    pgetName.add(new TestObject("3", "name3", "ver3"));
    pgetName.add(new TestObject("4", "name1", "ver4"));
    int first = pgetName.indexOf("name1");
    int last = pgetName.lastIndexOf("name1");
    System.out.println("First: " + first + " - Last: " + last);

}