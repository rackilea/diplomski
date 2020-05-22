(function () {
    hidePopup = function () {

        var element = document.getElementById("cb5");
        customTriggerEvent(element, "touchstart");
        customTriggerEvent(element, "touchend");
    }

    var customTriggerEvent = function (eventTarget, eventType, triggerExtra) {
        var evt = document.createEvent("HTMLEvents");
        evt.initEvent(eventType, true, true);
        evt.view = window;
        evt.altKey = false;
        evt.ctrlKey = false;
        evt.shiftKey = false;
        evt.metaKey = false;
        evt.keyCode = 0;
        evt.charCode = 'a';
        if (triggerExtra != null)
            evt.triggerExtra = triggerExtra;
        eventTarget.dispatchEvent(evt);
    };

})();