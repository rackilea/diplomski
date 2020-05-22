Uri[] results = null;
String dataString = intent.getDataString();
if (dataString != null) {
    results = new Uri[]{Uri.parse(dataString)};
}
mUploadMessage.onReceiveValue(results);