public void onDrawerClosed(View view) {
            super.onDrawerClosed(view);

            isDrawerOpen = false;
            // supportInvalidateOptionsMenu(); // creates call to
            // onPrepareOptionsMenu()
        }

        /** Called when a drawer has settled in a completely open state. */
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
            isDrawerOpen = true;
            // supportInvalidateOptionsMenu(); // creates call to
            // onPrepareOptionsMenu()
        }