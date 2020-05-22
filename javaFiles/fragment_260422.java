public static MyFragment newInstance(int arg) {

    Bundle args = new Bundle();
    args.putInt("ARG", arg);

    MyFragment fragment = new MyFragment();
    fragment.setArguments(args);
    return fragment;
}