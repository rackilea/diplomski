public class SmackJabber extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    this.cbContext = callbackContext;
    switch (action) {
            case LISTEN_MESSAGE:
                res = new PluginResult(PluginResult.Status.NO_RESULT);
                res.setKeepCallback(true);
                cordova.getThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        String callbackId = cbContext.getCallbackId();
                        while (true) {
                            String msg = getMsg();
                            if (msg != null) {
                                res = new PluginResult(PluginResult.Status.OK, msg);
                                res.setKeepCallback(true);
                                CallbackContext cb = new CallbackContext(callbackId, webView);
                                cb.sendPluginResult(res);
                            }
                        }
                    }
                });
                cbContext.sendPluginResult(res);
                break;