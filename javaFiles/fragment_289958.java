public class TestClass {
    public List<String> tops;

    public TestClass(List<String> newTops){
        changeTop(newTops);
    }

    public void printTop(){
        System.out.println(tops);
    }

    public void changeTop(List<String> tops){
        this.tops = tops;
    }

}