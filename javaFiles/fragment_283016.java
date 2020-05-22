public class ClassB implements myClass.OnStartListener {
    public void ClassB() {
        myClass test1 = new myClass(this);
        //test1.setListener(this);
        myClass.test();
    }

    @Override
    public void onStart() {
        System.out.println("start triggered");
    }
}