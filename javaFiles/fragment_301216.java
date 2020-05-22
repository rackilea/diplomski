@Override
    public void onDestroyView() {
        super.onDestroyView();
        Fragment f = (Fragment) fragmentManager
                .findFragmentById(R.id.container);
        if (f != null)
            fragmentManager.beginTransaction().remove(f).commit();
    }