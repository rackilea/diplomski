public void closeDrawer() {
    if (isDrawerOpen) {
        mDrawerLayout
                .closeDrawer((LinearLayout) findViewById(R.id.left_drawer));
    }
}