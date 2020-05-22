public class DataStructure {
    private float info1;
    private int info2;
    public DataStructure(float info1, int info2) {
        super();
        this.info1 = info1;
        this.info2 = info2;
    }
    public float getInfo1() {
        return info1;
    }
    public void setInfo1(float info1) {
        this.info1 = info1;
    }
    public int getInfo2() {
        return info2;
    }
    public void setInfo2(int info2) {
        this.info2 = info2;
    }

}

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        final HashMap<String, DataStructure> map = new HashMap<String, DataStructure>();

        map.put("apple", new DataStructure(5f, 1));

    }

}