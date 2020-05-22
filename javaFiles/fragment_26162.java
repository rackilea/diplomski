void callFragmentFromDrawer(int position) {
    Fragment f = null;
    switch (position) {
        case 0:
            f = MyFragment.newInstance();
            break;
        case 1:
        ...
    }

    if (f != null) {
        getActivity().getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.content_frame, f)
            .addToBackStack(list_contents[position])
            .commit();
    }
}