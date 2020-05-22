public class MyActivity extends Activity implements MyInterface {

    Runnable r = new MyRunnable(this);
    new Thread(r).start();

    @Override
    onRunnableDone(String runnableString){
        //do something with the string
    }
}