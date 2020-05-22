public class OneFragment extends Fragment{

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
    View returnView = inflater.inflate(R.layout.fragment_one, container, false);
    TextView txtOne = (TextView) returnView.findViewById(R.id.txt1);
    txtOne.setText("hello");

    return returnView;
}
}