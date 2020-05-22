public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_option_list,
                container, false);

        // here as an example
        final ListView list = (ListView) rootView.findViewById(R.id.optionList);
        Log.d("LISTA", list + "");

        return rootView;
    }
}