@Entity
public class A {


    public static int MAX_NUM_B = 4;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<B> b= new LinkedHashSet<B>();

    public void addB(B b) {
        if (this.b.size() == MAX_NUM_B) {
            Iterator<B> it = this.b.iterator();
            it.next();
            it.remove();
        }
        this.b.add(b);
    }

    public Set<B> getB() {
        return Collections.unmodifiableSet(this.b);
    }
}