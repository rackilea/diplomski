static final Map<String,String> codeMsgMap = new HashMap<>();
// Changes in the above map will be reflected here.
static final Map<String,String> unmodifiableCodeMsgMap = Collections.unmodifiableMap(codeMsgMap);

public static Map<String, String> getResponseCodeSource() {
    return unmodifiableCodeMsgMap;
}