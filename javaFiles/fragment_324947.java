public class RRR {
    public static void main(String[] args) {
        ArrayList <Hi> hiList = new ArrayList <> ();
        Hi hi1 = new Hi("one");
        Hi hi2 = new Hi("two");
        Hi hi3 = new Hi("three");
        hiList.add(hi1);
        hiList.add(hi2);
        hiList.add(hi3);
        Hi hix = hiList.get(0);
        hix.setName("haha");
        System.out.println(hiList.get(0).getName());    // changed from "one" to "haha"
    }


}

class Hi {
    public Hi(String name) {
        this.name = name;
    }
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}