public class CalendarFragment extends Fragment implements OnDateSelectedListener {


    private MaterialCalendarView calendarView;
    private HashMap<CalendarDay,List<Event>> map = new HashMap<>();
    private ListView listView;
    private MyAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.calendar, container, false);

        listView = view.findViewById(R.id.listview);

        adapter = new MyAdapter(getActivity(),new ArrayList<Event>());
        listView.setAdapter(adapter);

        calendarView =  view.findViewById(R.id.calendarView);
        calendarView.setDateTextAppearance(View.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);

        calendarView.setSelectedDate(LocalDate.now());

        calendarView.setOnDateChangedListener(this);

        makeJsonObjectRequest();

        return view;
    }




    private void makeJsonObjectRequest() {

        String response = loadJSONFromAsset();
        try {
            JSONArray jArray = new JSONArray(response);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                String StartDate = jsonObject.getString("StartDate");
                LocalDate date = LocalDate.parse(StartDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss",Locale.US));

                String title =  jsonObject.getString("Title");

                Log.d("Date ",""+date);
                CalendarDay day = CalendarDay.from(date);
                Event event = new Event(date,title);


                if(!map.containsKey(day))
                {
                    List<Event> events = new ArrayList<>();
                    events.add(event);
                    map.put(day,events);
                }else
                {
                    List<Event> events = map.get(day);
                    events.add(event);
                    map.put(day,events);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // after parsing
        List<Event> event =  map.get(CalendarDay.from(LocalDate.now()));
        if(event!=null && event.size()>0) {
            adapter.addItems(event);
        }else {
            adapter.clear();
        }

        //add small dots on event days
        EventDecorator eventDecorator = new EventDecorator(Color.RED, map.keySet());
        calendarView.addDecorator(eventDecorator);


    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("testjson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

        calendarView.setHeaderTextAppearance(R.style.AppTheme);

        List<Event> event =  map.get(date);
        if(event!=null && event.size()>0) {
            adapter.addItems(event);
        }else {
            adapter.clear();
        }
    }

}