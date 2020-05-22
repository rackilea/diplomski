synchronized(ownedWindowList) {
        for (int i = 0; i < ownedWindowList.size(); i++) {
            Window child = ownedWindowList.elementAt(i).get();
            if ((child != null) && child.visible) {
                child.hide();
                child.showWithParent = true; // See here the flag set to true
            }
        }
    }