public class MyEvaluator extends BaseEvaluator {

    private ScriptRemote remote;

    public void setRemote(ScriptRemote remote) {
        this.remote = remote;
    }

    public void doScriptCall() {
        Response response = remote.call("/api/...");
    }

}