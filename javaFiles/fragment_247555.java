public static IconsFragment newInstance(IconsCategory category) {
    IconsFragment fragment = new IconsFragment();
    Bundle args = new Bundle();
    args.putParcelable("category", category); 
    fragment.setArguments(args);
    return fragment;
}