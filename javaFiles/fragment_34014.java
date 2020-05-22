Public class  Tab2Vid extand Fragment implement View.OnClickListener {

    Public View onCreateView(LayoutInflater inflater, ViewGroup container
                            ,Bundle savedlnstanceState) {

    View rootView = inflater.inflate(R.layout.tab2video, container, false); 

    Button play = (Button)rootView.findViewById(R.id.btnplay);

    return rootView; 

    }

    Public void onClick(View view)( 
    switch (view.getId())
        {

            case R.id.btnplay:
              Toast.makeText(getActivity(),"Btn Play clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                return;
        }
    } 
}