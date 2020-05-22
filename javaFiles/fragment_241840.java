/* Attempt to load the applet up to "X" times with a delay. If it succeeds, then execute the callback function. */
function WaitForAppletLoad(applet_id, attempts, delay, onSuccessCallback, onFailCallback) {
    //Test
    var to = typeof (document.getElementById(applet_id));
    if (to == 'function' || to == 'object') {
        onSuccessCallback(); //Go do it.
        return true;
    } else {
        if (attempts == 0) {
            onFailCallback();
            return false;
        } else {
            //Put it back in the hopper.
            setTimeout(function () {
                WaitForAppletLoad(applet_id, --attempts, delay, onSuccessCallback, onFailCallback);
            }, delay);
        }
    }
}