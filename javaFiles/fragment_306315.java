public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
 View v = inflater.inflate(R.layout.frag2,container,false);
 LinearLayout linearni = (LinearLayout)v.findViewById(R.id.linearni);

dugme = (Button) v.findViewById(R.id.dugme);
dugme.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Button newbtn = new Button(getActivity().getApplicationContext());
        newbtn.setLayoutParams(new LinearLayout.LayoutParams(150,150));
        newbtn.setText("Yea");
        linearni.addView(newbtn);
    }
});
return v;
}