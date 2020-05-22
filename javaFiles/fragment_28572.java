Event.addNativePreviewHandler(e -> {
        // Listen to all events before a widget gets the chance, only handle the "mouseover".
        // Depenending on which ToolTip is used, a "mouseout" handler might be desirable too,
        // to hide the tooltip, or else just use a single instance and move it around the page
        // as needed
        if (e.getTypeInt() != Event.ONMOUSEOVER) {
            return;
        }

        // If the event somehow happens to a non-element, ignore
        EventTarget eventTarget = e.getNativeEvent().getEventTarget();
        if (!Element.is(eventTarget)) {
            return;
        }

        // examine each node up the hierarchy until a parent is found, or we run out of options
        Element elt = eventTarget.cast();
        // Could also add that instanceof check here, ignore non-Widgets
        while (DOM.getEventListener(elt) == null) {
            elt = elt.getParentElement();
            if (elt == null) {
                // give up
                return;
            }
        }

        // Whatever we've found is attached to that element to handle events like a widget would.
        // Other examples include UIObjects (like tree nodes) or GQuery event listeners
        Object attachedObject = DOM.getEventListener(elt);

        // Log it (assumes elemental2, could just as easily use GWT.log()
        // but really should be replaced by your preferred ToolTip
        DomGlobal.console.log(attachedObject.getClass());
    });