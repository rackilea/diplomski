public class FlightFragment extends Fragment {

GridView grid;

public FlightFragment() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_flight, container, false);
    // Inflate the layout for this fragment
    grid = (GridView) view.findViewById(R.id.gridView);
    MyAdapter myAdapter = new MyAdapter(getActivity());
    grid.setAdapter(myAdapter);
    return view;

}

class MyAdapter extends BaseAdapter {

    ArrayList<Schedule> list;
    private Context context;

    MyAdapter(Context context) {
        this.context = context;
        list = new ArrayList();
        Resources resources = context.getResources();
        String[] tempPlaces = resources.getStringArray(R.array.PlacesName);
        String[] tempDate = resources.getStringArray(R.array.ScheduleDate);
        String[] tempDescription = resources.getStringArray(R.array.Description);
        for(int count=0;count<4;count++ ){
            Schedule tempSchedule = new Schedule(tempPlaces[count],tempDate[count],tempDescription[count]);
            list.add(tempSchedule);
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Schedule tempSchedule = list.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_row, parent, false);
        }
        TextView placeName = (TextView) convertView.findViewById(R.id.place_name);
        TextView scheduleDate = (TextView) convertView.findViewById(R.id.schedule_date);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        placeName.setText(tempSchedule.Place);
        scheduleDate.setText(tempSchedule.ScheduleTime);
        description.setText(tempSchedule.Description);
        return convertView;
    }
}