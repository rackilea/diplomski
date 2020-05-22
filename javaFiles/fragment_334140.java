private int mFragmentIndex = 0;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
        mFragmentIndex = getArguments().getInt(ARG_SECTION_NUMBER);
    }
}