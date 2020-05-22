native String getBinaryResource(String url) /*-{
    // ...implemented with JavaScript                 
    var req = new XMLHttpRequest();
    req.open("GET", url, false);  // The last parameter determines whether the request is asynchronous -> this case is sync.
    req.overrideMimeType('text/plain; charset=x-user-defined');
    req.send(null);
    if (req.status == 200) {                    
        return req.responseText;
    } else return null
}-*/;