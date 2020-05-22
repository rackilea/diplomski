public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView im = (ImageView) rootView.findViewById(R.id.mainnews);
            im.getLayoutParams().height = 23;
            im.setScaleType(ImageView.ScaleType.FIT_XY);
            return rootView;
        }
    }