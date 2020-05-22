getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
    getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

    setBehindContentView(R.layout.menu_frame);

    FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
                mFrag = new SampleListFragment();
                t.replace(R.id.menu_frame, mFrag);
                t.commit(); //left menu

getSlidingMenu().setSecondaryMenu(R.layout.right_menu_layout);
        getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
        getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.right_list, new RightListFragment())
        .commit(); //right menu