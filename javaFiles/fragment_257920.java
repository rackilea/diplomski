public native void setSelectionRange(Element elem, int pos, int length) /*-{
    try {
        var selection = null, range2 = null;
        var iframeWindow = elem.contentWindow;
        var iframeDocument = iframeWindow.document;

        selection = iframeWindow.getSelection();
        range2 = selection.getRangeAt(0);

        //create new range
        var range = iframeDocument.createRange();
        range.setStart(selection.anchorNode, pos);
        range.setEnd(selection.anchorNode, length);

        //remove the old range and add the newly created range
        if (selection.removeRange) { // Firefox, Opera, IE after version 9
            selection.removeRange(range2);
        } else {
            if (selection.removeAllRanges) { // Safari, Google Chrome
                selection.removeAllRanges();
            }
        }
        selection.addRange(range);
    } catch (e) {
        $wnd.alert(e);
    }
}-*/;