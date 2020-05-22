public class MyApplictaion extends Application {
private static MyApplication myApplication = null;
public Map<String, String> fontDic;

@Override
public void onCreate() {
    super.onCreate();
    fontDic = new HashMap<String, String>();
    fontDic.put("1", "0x0627");
    fontDic.put("2", "0x0628");
    fontDic.put("3", "0x062A");
    fontDic.put("4", "0x062B");
}

public static MyApplication getInstance() {
    if (myApplication == null) {
        myApplication = new MyApplication();
    }
    return myApplication;
}