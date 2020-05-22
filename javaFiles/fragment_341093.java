1821        // First we always handle the home key here, so applications
1822        // can never break it, although if keyguard is on, we do let
1823        // it handle it, because that gives us the correct 5 second
1824        // timeout.
1825        if (keyCode == KeyEvent.KEYCODE_HOME) {
1826
1827            // If we have released the home key, and didn't do anything else
1828            // while it was pressed, then it is time to go home!
1829            if (!down) {
1830                final boolean homeWasLongPressed = mHomeLongPressed;
1831                mHomePressed = false;
1832                mHomeLongPressed = false;
1833                if (!homeWasLongPressed) {
1834                    if (mLongPressOnHomeBehavior == LONG_PRESS_HOME_RECENT_SYSTEM_UI) {
1835                        try {