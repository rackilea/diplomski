function createPageView(link) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            window.location = link.href; // See?
        }
    }
    xhr.open('GET', 'http://example.com', true);
    xhr.send(null);
    return false; // Block link's default action.
}