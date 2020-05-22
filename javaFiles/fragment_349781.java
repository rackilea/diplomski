@SuppressLint("ValidFragment")
    public static class OnlineFragment extends Fragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            View rootview = inflater.inflate(R.layout.fragment_online, container, false);
           Button b1 = (Button) rootview.findbyid(R.id.s)
            return rootview;
        }
    }