public class Main {
    public static void main(String[] args){

    Program3a testClass = new Program3a();

    testClass.setName("Rex");
        System.out.println(testClass.getName());
    }
}

public  class Program3a {
    private  String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}