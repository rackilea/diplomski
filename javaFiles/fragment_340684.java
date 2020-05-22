native String getBinaryResource(String url) /*-{
    var req = new XMLHttpRequest();
    req.open("GET", url, false);  // The last parameter determines whether the request is asynchronous.
    req.overrideMimeType('text/plain; charset=x-user-defined');

    req.send(null);
    if (req.status == 200) {
        return req.responseText;
    } else return null
}-*/;

private void sendRequestBinary() {
    String url = URL.encode("/Computer_File_030.gif");
    String data = getBinaryResource(url);
    if (data != null) {
        // The secret sauce: Method to decode the binary data in the response string
        byte[] binData = new byte[data.length()];
        for (int i=0;i<data.length();i++) {
            binData[i] = (byte)(data.charAt(i) & 0xff);
        }
        final HTML imageHolder = new HTML();
        String base64=Base64Utils.toBase64(binData);

        String imgTag = "<IMG src='data:image/gif;base64,"+base64+"' />'";
        imageHolder.setHTML(imgTag);
            RootPanel.get("imageContainer").add(imageHolder);
            errorLabel.setText("Base64:");
    } else {
        errorLabel.setText("Another error :-(");
    }
}