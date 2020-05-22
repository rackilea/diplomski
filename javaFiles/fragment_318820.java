setBehindContentView(R.layout.menu_frame);

        menu.setMenu(R.layout.menu_frame);
        getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.menu_frame, new MenuFragment())
        .commit();

        menu.setSecondaryMenu(R.layout.menu_frame_two);
        menu.setSecondaryShadowDrawable(R.drawable.shadowright);
        getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.menu_frame_two, new MenuTwoFragment())
        .commit();