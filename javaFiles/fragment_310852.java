addTab("Home", ???);

private <T extends Fragment> void addTab(String text, Class<T> clazz) {
    Tab myTab = myActionBar.
                newTab().
                setText(text).
                setTabListener(new TabListener<T>(
                    this, 
                    text, 
                    clazz
                ));
    ...
}