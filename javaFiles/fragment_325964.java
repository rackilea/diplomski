new Ajax.Request(myUrlToCall, {
method:'POST',
    onComplete: function(transport) {
        window.location.replace(theRedirectUrl);
    }
});