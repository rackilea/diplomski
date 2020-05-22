function makeUrl(q) {
    var url = options.url + "?q=" + encodeURI(q);
    for (var i in options.extraParams) {
        url += "&" + i + "=" + encodeURI(options.extraParams[i]);
    }
    return url;
};