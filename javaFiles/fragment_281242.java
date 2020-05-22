public static BlankFragment newInstance(String str) {
    BlankFragment f = new BlankFragment();
    Bundle args = new Bundle();
    args.putString("TextTag", str);
    f.setArguments(args);
    return (f);
}