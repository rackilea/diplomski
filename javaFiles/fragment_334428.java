public class TheoryFragment extends Fragment {

     public static TheoryFragment newInstance() {
            TheoryFragment fragment = new TheoryFragment();
            return fragment;
        }
     @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_theory, container, false);
            unbinder = ButterKnife.bind(this, rootView);
            return rootView;
        }
    }