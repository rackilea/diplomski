public class Async {

    public void executeHTTP(Context context, int id){
        ...
        ((YourInterface)context).onComplete(id);
    }

}