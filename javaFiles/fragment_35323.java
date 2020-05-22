@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    a = (Button) getActivity().findViewById(R.id.button);
    t1 = (TextView) getActivity().findViewById(R.id.textView);
    t2 = (TextView) getActivity().findViewById(R.id.textView2);

    if (getArguments() != null) {
          t1.setText(getArguments().getString("A"));
          t2.setText(getArguments().getString("B"));
    }
}