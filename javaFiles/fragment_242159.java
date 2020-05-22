public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tx = (TextView)rootView.findViewById(R.id.hello_world);
        tx.setText(editText.getText().toString());
        return rootView;
    }
}