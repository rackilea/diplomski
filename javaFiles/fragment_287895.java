public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_invalid_time, container, false);
        title = (TextView)view.findViewById(R.id.titleText);
        setTheTitle(getActivity().getString(R.string.invalidTimeTitle));

        return view;
    }