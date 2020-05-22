public static class FragmentFirst extends Fragment {
    public static FragmentFirst newInstance(int sectionNumber) {
        FragmentFirst fragment = new FragmentFirst();
        return fragment;
    }

    public FragmentFirst() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView;
    }
}

public static class FragmentSecond extends Fragment {
    public static FragmentSecond newInstance(int sectionNumber) {
        FragmentSecond fragment = new FragmentSecond();
        return fragment;
    }

    public FragmentSecond() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        return rootView;
    }
}

public static class FragmentThird extends Fragment {
    public static FragmentThird newInstance(int sectionNumber) {
        FragmentThird fragment = new FragmentThird();
        return fragment;
    }

    public FragmentThird() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        return rootView;
    }
}