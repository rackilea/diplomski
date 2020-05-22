public class tab2 extends Fragment {  
@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.tab2,container,false);

        ImageButton pigsButton = (ImageButton) view.findViewById(R.id.pigsButton);

        pigsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tab2.this, pigs_story.class);
                startActivity(i);
            }
        });

        return view;
    }

}