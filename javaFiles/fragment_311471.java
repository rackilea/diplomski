private void fastLog(Object... obj) {
    String log = "";
    for(Object o : obj) {
        log += o + " ";
    }
    Log.d("FastLog", log);
}