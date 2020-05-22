public class AnyFragment extends Fragment {

    //View of Fragment
    private View viewObj=null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //insted of inflating new view it will check for the previous view as well
        if(viewObj==null){
        viewObj= inflater.inflate(R.layout.fragment_output_sequeleye, container, false);
       }

        return viewObj;
    }
}