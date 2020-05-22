public class HomeFragment extends Fragment {

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            btnCheckFalAction = (Button) rootView.findViewById(R.id.btnCheckFal); // you have to use rootview object..
            btnCheckFalAction.setOnClickListener(new OnClickListener() {           

                  @Override
                  public void onClick(View v) 
                  {
                      Toast.makeText(getActivity(), "Hello World", Toast.LENGTH_LONG).show();
                  }    
                });

        return rootView;
    }
}