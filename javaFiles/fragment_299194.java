public class Main {
    String str = null;
    public static void main(String[] args) {
        Main m1 = new Main();
        m1.setTheValueHere();
        m1.getTheValueHere("called by m1");

        Main m2 = new Main();
        m2.getTheValueHere("called by m2");
    }

    protected void setTheValueHere(){
        str = "hello";
    }

    public void getTheValueHere(String objName) {
        System.out.println(objName +" --- "+str);
    }
}