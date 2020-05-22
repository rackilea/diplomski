public class Bean {

    public Bean() {
        this("");
    }

    public Bean(String name) {
        this.name = name ;
    }

    private String name ;

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }
}