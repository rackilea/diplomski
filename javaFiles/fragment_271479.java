public class EnvConfig {

    private String rawJSONString;
    private JSONObject jsonObjRecv; // <-- you declare a class variable here

    // ...

    try {
        JSONObject jsonObjRecv = new JSONObject(rawJSONString); // <-- shadowed here!