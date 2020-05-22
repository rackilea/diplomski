public abstract class NewClass implements NewInterface{

    @Override
    public  abstract void show();

    public  abstract NewClass show1();

    // This method cannot be overridden
    public  final void show2(){
    }
}