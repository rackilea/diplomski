public class Thingy{
    private final String foo = "hey";
    private final int bar = 123;
    private final List<String> grr = Arrays.asList("1", "2", "3");

    public String getFoo(){
        return this.foo;
    }
    public int getBar(){
        return this.bar;
    }
    public List<String> getGrr(){
        return this.grr;
    }
}