public void configureToolbar(int id) {
    mToolbar = (Toolbar) findViewById(id);
    mToolbar.setElevation(0);
    mToolbar.setTitle("");

    setSupportActionBar(mToolbar);
}