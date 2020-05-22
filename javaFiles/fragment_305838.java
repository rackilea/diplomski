public interface RestCallBack {

    void onStart(String action);

    void onComplete(String response, String action,Exception e);
}