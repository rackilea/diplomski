mDrawerToggle.setToolbarNavigationClickListener(
            new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        }
    );