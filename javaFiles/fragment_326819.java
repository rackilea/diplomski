@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.profile, container, false);

Button newPage = (Button) v.findViewById(R.id.button2);
newPage.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), FirstActivity.class);
        startActivity(intent);
    }
});

Button newPage1 = (Button) v.findViewById(R.id.button1);
newPage1.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        startActivity(intent);
    }
});

Button newPage2 = (Button) v.findViewById(R.id.button3);
newPage2.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ThirdActivity.class);
        startActivity(intent);
    }
});
return v;

}