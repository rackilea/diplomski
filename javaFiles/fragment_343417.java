public abstract class MainAbstract {

    //..existing code..

    public static void main(String[] args) {

        SubAbstract subAbstract = new SubAbstract(10, "someName", "someType");
        subAbstract.showInfo();
    }
}