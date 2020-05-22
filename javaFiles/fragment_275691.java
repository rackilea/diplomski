public class MyClass implements IGetJsonListener {
     (...)
     new GetJsonTask(context, this, "https://your.url.com/").execute();

     @Override
     public void getJsonFinished(JsonObject resJson, APIStatus status) {
        //Handle JSON content from web here
        (...)
     }
     (...)
}