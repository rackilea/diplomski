jsf.ajax.addOnEvent(function(data) {
    switch(data.status) {
        case "begin":
            // This is invoked right before ajax request is sent.
            break;

        case "complete":
            // This is invoked right after ajax response is returned.
            break;

        case "success":
            // This is invoked right after successful processing of ajax response and update of HTML DOM.
            // In case you're interested in error handling, use jsf.ajax.addOnError handler.
            break;
    }
});