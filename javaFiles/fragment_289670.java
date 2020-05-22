public class Home extends Fragment {

@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.frag_home, container, false);

    ImageButton workButton = (ImageButton) view.findViewById(R.id.work_button);
    ImageButton calendarButton = (ImageButton) view.findViewById(R.id.calendar_button);

    workButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Work()).addToBackStack(null).commit

            NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(position).setChecked(true);

        }
    });