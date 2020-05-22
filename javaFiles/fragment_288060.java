@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.activity_main2, container, false);

    final Button button1 = v.findViewById(R.id.button);
    final Button button2 = v.findViewById(R.id.button2);
    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            button1.setBackgroundResource(R.color.gray);
            button2.setBackgroundResource(R.color.black);
        }
    });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            button1.setBackgroundResource(R.color.black);
            button2.setBackgroundResource(R.color.gray);

        }
    });
    return v;
}