public class HomeFragment extends Fragment implements OnClickListener{

    public HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            btnCheckFalAction = (Button) rootView.findViewById(R.id.btnCheckFal); // you have to use rootview object..
            btnCheckFalAction.setOnClickListener(this);

        return rootView;
    }
    @Override
    public void onClick(View v) {
     // TODO Auto-generated method stub
     switch(v.getId()){

     case R.id.btnCheckFal :
         //your code...
     break;

    default:
        break;

     }

    }
}