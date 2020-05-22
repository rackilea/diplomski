public Fragment getItem(int position) {
    UserFragment fragment = new UserFragment();
    Bundle args = new Bundle();
    args.putInt("page_position", position + 1);
    fragment.setArguments(args);
    return fragment;
}