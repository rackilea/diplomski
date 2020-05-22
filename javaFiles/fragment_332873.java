@Entity
public class Foo extends BaseModel {

    public static final Find<Long, Foo> find = new Find<Long, Foo>() {};

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bars1")
    private List<Bar> bars1;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bars2")
    private List<Bar> bars2;

    public List<Bar> getBars1() {
        return bars1;
    }

    public void setBars1(List<Bar> bars1) {
        this.bars1 = bars1;
    }

    public List<Bar> getBars2() {
        return bars2;
    }

    public void setBars2(List<Bar> bars2) {
        this.bars2 = bars2;
    }

}