function(responseJson) {
    if (responseJson.redirect) {
        window.location = responseJson.redirect;
        return;
    }

    // ...
}