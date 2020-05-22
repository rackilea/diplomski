for (int i = 0; i < ownedWindowList.size(); i++) {
            Window child = ownedWindowList.elementAt(i).get();
            if ((child != null) && child.showWithParent) { // Here theh flag is checked
                child.show();
                child.showWithParent = false; // flag is then reset
            }       // endif
        }