public class TabFragment1 extends Fragment {
    ImageButton imageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                                Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        imageButton = (ImageButton)view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), NewActivity.class));
            }
        });
        return view;
      }
      }