@Override
public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

View view =inflater.inflate(R.layout.new_fragment, container, false);
TextView FragmentTextView = (TextView)view.findViewById(R.id.FragmentTextView);
return view;
}