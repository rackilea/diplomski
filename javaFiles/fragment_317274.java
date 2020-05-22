public class ScenariaResults {

    private String id;

    private String name;

    private String load;

    private int passCount;

    private int failCount;

    public ScenariaResults(String id, String name, String load, int passCount,
            int failCount) {
        super();
        this.id = id;
        this.name = name;
        this.load = load;
        this.passCount = passCount;
        this.failCount = failCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public int getPassCount() {
        return passCount;
    }

    public void setPassCount(int passCount) {
        this.passCount = passCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    @Override
    public String toString() {
        return "ScenariaResults [id=" + id + ", name=" + name + ", load="
                + load + ", passCount=" + passCount + ", failCount="
                + failCount + "]";
    }

}