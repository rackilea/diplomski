@Named
@ViewScoped
public class TestBean {
    private String name;

    @PostConstruct
    public void onload() {
        name="José";
    }

    public String save() {
        System.out.println(name);
        return null;
    }

    //getters
    //setters
}