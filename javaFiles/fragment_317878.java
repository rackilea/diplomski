HttpURLConnection c = ....;
InputStream is;
if ((c.getResponseCode()/100)==2) {
    is = c.getInputStream();
} else {
    is = c.getErrorStream(); // instead of normal Input Stream
}

// read your HTML from is