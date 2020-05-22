enum BackgroundType{ GET, POST }

public interface onBackgroundTaskListener<T> {
    void onTaskComplete(T result, BackgroundType type);
}

--------------------------
BackgroundTask bt1 = new BackgroundTask(this, ApiHelper.GET, GET);
bt.execute(url1);

BackgroundTask bt2 = new BackgroundTask(this, ApiHelper.POST, params, POST);
bt.execute(url2);
------------------------
@Override
public void onTaskComplete(String result,  BackgroundType type) {
    switch(type){
      case GET:
         break;
      case POST:
         break;
    }
}