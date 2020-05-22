getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_left, 0, 0,
                                R.anim.exit_to_left)
                        .add(R.id.dummy, new SliderMenuActivity())
                        .addToBackStack("animation").commit();