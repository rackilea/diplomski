public class PersonalDetailsFragment extends Fragment implements View.OnClickListener {

        private TextInputLayout mFirstName;
        private TextInputLayout mInitials;
        private TextInputLayout mLastName;
        private Button mContinueBtn;
        private RadioButton mFemale;
        private RadioButton mMale;

        private DatabaseReference mDatabase;

        //ProgressDialog
        private ProgressDialog mRegProgress;

        private ViewPager mViewPager;
        private SectionsPagerAdapter mSectionsPagerAdapter;
        private TabLayout mTabLayout;

        //Firebase Auth
        private FirebaseAuth mAuth;

        View v;

        boolean male = true;

        // private RadioGroup radioGroup;

        public PersonalDetailsFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            v = inflater.inflate(R.layout.fragment_personal_details, container, false);

            mRegProgress = new ProgressDialog(this.getActivity().getApplicationContext());

            // Firebase Auth
            mAuth = FirebaseAuth.getInstance();

            mContinueBtn = (Button) v.findViewById(R.id.btnContinue);
            mContinueBtn.setOnClickListener(this);

            mViewPager = (ViewPager) getActivity().findViewById(R.id.main_tabPager);

            mFirstName = (TextInputLayout) v.findViewById(R.id.inpuutCellNumber);
            mInitials = (TextInputLayout) v.findViewById(R.id.inputHomeNumber);
            mLastName = (TextInputLayout) v.findViewById(R.id.inputWorkNumber);


            final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.gender);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.radioMale:
                            male = true;
                            break;
                        case R.id.radioFemale:
                            male = false;
                            break;
                    }
                }
            });

            return v;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            // save views as variables in this method
            // "view" is the one returned from onCreateView
            // Android Fields

        }

        @Override
        public void onClick(View v) {
        if (v == mContinueBtn) {

                    String first_Name = mFirstName.getEditText().getText().toString();
                    String initials = mInitials.getEditText().getText().toString();
                    String lastName = mLastName.getEditText().getText().toString();


                    if ( TextUtils.isEmpty( first_Name ) || TextUtils.isEmpty( initials ) || TextUtils.isEmpty( lastName ) )
                    {
                        Toast.makeText( getActivity().getApplicationContext(), "Make sure all fields are filled in.", Toast.LENGTH_LONG ).show();
                    } else {
                        mViewPager.setCurrentItem(1);
                    }


              }
         }

    }