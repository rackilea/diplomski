public class GroupFrequencyFragment extends GroupCreationFragment {

    private static final String TAG = "GroupFrequencyFragment";
    private static TextView activityLabel;
    public GroupFrequencyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_frequency, container, false);

        setFragmentViews(view);
        return view;
    }

    @Override
    public void setFragmentViews(View view) {
        initFrequencyViews(view);
        setActivityLabel();
    }

    public void setActivityLabel() {
        if (GroupBuilder.getInstance().getActivityType() != null) {
            String type = GroupBuilder.getInstance().getActivityType();
            switch (type) {
                case "exercise regularly":
                    // Set the right label
                    Log.i(TAG, "setActivityLabel: activityLabel = " + activityLabel);
                    activityLabel.setText("workouts every");
                    break;
                default:
                    break;
            }
        }
    }

    private void initFrequencyViews(View view) {
        activityLabel = view.findViewById(R.id.activity_label);
        ...
    }