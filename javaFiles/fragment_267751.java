mDrawerToggle.setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
mDrawerToggle.setToolbarNavigationClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    }
);