public static MyFragment newInstance(int arg1, String arg2) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("arg1Key", arg1);
        args.putInt("arg1Key", arg2);
        fragment.setArguments(args);
        return fragment;
    }

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        myArg1 = getArguments().getInt("arg1Key");
        myArg2 = getArguments().getInt("arg2Key");
    }
}