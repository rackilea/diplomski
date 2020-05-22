private View mRootView;
private  EditText mEditText;

public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // If mItem is non-null...
    if (mItem != null) {
        if (mItem.title == "Calculation") {
            // If the title is Calculation, use the calculation layout
            mRootView = inflater.inflate(R.layout.calculation_layout, container, false);
            mEditText = (EditText) mRootView.findViewById(R.id.edit_phiD);    
            ((Button)mRootView.findViewById(R.id.calc_button)).setOnClickListener(this);         
        } else {
            // Otherwise, show the dummy content as text in a TextView
            mRootView = inflater.inflate(R.layout.fragment_screen_detail, container, false);
            ((TextView) mRootView .findViewById(R.id.screen_detail)).setText(mItem.title);
        }
    } else {
        mRootView = inflater.inflate(R.layout.fragment_screen_detail, container, false);
    }

    return mRootView;
}