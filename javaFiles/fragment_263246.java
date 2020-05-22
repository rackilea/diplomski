public class Async {

    public void executeHTTP(Context context){
        ...
        ((YourInterface)context).onComplete();
    }

}