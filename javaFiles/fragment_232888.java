private native void addNativeMouseWheelListener(ValueBox instance, String id) /*-{
    function mouseOverHandler(e) {
        $wnd.addEventListener("DOMMouseScroll", scrollWheelMove, false);
    }

    function mouseOutHandler(e) {
        $wnd.removeEventListener("DOMMouseScroll", scrollWheelMove, false);
    }

    function scrollWheelMove(e) {
        if ($wnd.event || $wnd.Event) {
                if (!e) e = $wnd.event;
                if (e.wheelDelta <= 0 || e.detail > 0 ) {
                        $wnd.alert("DOWN");
                } else {
                        instance.@com.proprintsgear.design_lab.client.ValueBox::increaseValue()();
                }
                instance.@com.proprintsgear.design_lab.client.ValueBox::fireChange()();
        }
    }

    var box=$doc.getElementById(id);
    box.addEventListener("mouseout",mouseOutHandler,false);
    box.addEventListener("mouseover",mouseOverHandler,false);
}-*/;