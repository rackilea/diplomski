public class MainActivity extends Fragment implements View.OnClickListener {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.main_activity, container, false);

    Button button1 = (Button) v.findViewById(R.id.button1);
    button1.setOnClickListener(this);
    Button button2 = (Button) v.findViewById(R.id.button2);
    button2.setOnClickListener(this);
    Button button3 = (Button) v.findViewById(R.id.button3);
    button3.setOnClickListener(this);

    return v;
}

@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.button1:
           Intent intent = new Intent(getActivity(),FirstActivity.class);
           startActivity(intent);
            break;
        case R.id.button2:
            // launch Activity2
            break;
        case R.id.button3:
            // launch Activity3
            break;
    }
}

}