public class Fragment1 extends CustomFragment {


        public Fragment1() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_1, container, false);
        }

        @Override
        public void refresh(){
            // TODO: this to be call when refresh on MainActivity and also fragment_1 is visible 
        }
}