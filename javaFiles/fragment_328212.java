@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    b1 = (Button) getActivity().findViewById(R.id.button);
    b1.setOnClickListener(this);
    b2 = (Button) getActivity().findViewById(R.id.button2);
    b2.setOnClickListener(this);
    b3 = (Button) getActivity().findViewById(R.id.button3);
    b3.setOnClickListener(this);
}