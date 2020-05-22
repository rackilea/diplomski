switch (position){
        case 0:
            fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, new MainFragment(), null)
                .addToBackStack(null)
                .commit();
            Sort.setVisibility(View.VISIBLE);
            toolbar.setTitle("Home");
            break;
        case 1:
            fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, new WorkoutsFragment(), null)
                .addToBackStack(null)
                .commit();
            Sort.setVisibility(View.GONE);
            toolbar.setTitle("My Workouts");
            break;
        case 2:
            fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, new ProfileFragment(), null)
                .addToBackStack(null)
                .commit();
            Sort.setVisibility(View.GONE);
            toolbar.setTitle("Profile");
            break;
    }