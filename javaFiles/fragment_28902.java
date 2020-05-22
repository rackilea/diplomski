public class FragmentPowerlifting extends Fragment {

    public FragmentPowerlifting() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        // store the layout in a view variable
        View v = inflater.inflate(R.layout.fragment_powerlifting, container, false);
        // use this view ("v") to retrieve elements on the layout by its id
        ImageButton imgButton = (ImageButton) v.findViewById(R.id.btnProgramiPL5x5);
        // set a listener to the button
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open a new activity when onClick is triggered
                Intent intent = new Intent(getActivity(), ProgramiPowerLiftingActivity.class);
                startActivity(intent);
            }
        }
        // return the inflated view to display it
        return v;
   }
}