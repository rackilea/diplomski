public class UnitOfWork implements Runnable
{
    String text;

    public UnitOfWork(String text){
        this.text = text;
    }

    public void run(){
        System.out.println(text);
    }
}