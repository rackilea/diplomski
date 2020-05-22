public class Metal {

    private boolean res;
    private String name;

    public Metal() {
        this.res = false;
    }

    public Metal (boolean res, String name) {
        this.res = res;
        this.name = name;
    }

    public boolean isEnchanted() {
        return res;       
    }

    @Override
    public String toString() {
        return name;       
    }
}