ActivitySlider slider = new ActivitySlider(activity);
slider.setMenuFragment(MenuFragment.class);

// The menu is shown with a width of 200 dip
slider.showMenu(200);

...

// Hide the menu again
slider.hideMenu();