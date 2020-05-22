import java.util.List;

public class User {
    private int usrid;
    private String name;
    private double weight;
    private int age;
    private List<String> Pnum;

    public User(int usrid, String name, double weight, int age, List<String> Pnum){
        this.usrid = usrid;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.Pnum = Pnum;

    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getPnum() {
        return Pnum;
    }

    public void setPnum(List<String> pnum) {
        Pnum = pnum;
    }

    int getUID(){
        return usrid;
    }
}