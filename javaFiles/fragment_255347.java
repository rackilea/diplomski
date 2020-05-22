public static class MainSectionFragment extends Fragment {

    private EditText mAcu1ET;
    private TextView mAcu1TV;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.main, container, false);

            mAcu1ET = (EditText) rootView.findViewById(R.id.edit_A1);
            mAcu1TV = (TextView) rootView.findViewById(R.id.act1);

            mAcu1ET.setOnEditorActionListener(new OnEditorActionListener() {
                @Override
                public boolean onEditorAction( TextView v, int actionId, KeyEvent event ) {   
                        mAcu1TV.setText(mAcu1ET.getText().toString());
                     return false;
                }
            });
            return rootView;
        }
    }