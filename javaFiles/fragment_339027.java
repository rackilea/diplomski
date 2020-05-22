private List<String> a;
private List<String> b;

@PostConstruct
public void init() {
    a = new ArrayList<String>();
    a.add("A");
    a.add("B");

    b = new ArrayList<String>();
    b.add("C");
    b.add("D");
}