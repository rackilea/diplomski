@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("Name", "One");
        map.put("Icon", R.drawable.icon);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("Name", "Two");
        map.put("Icon", R.drawable.icon);
        list.add(map);

        Spinner spin = (Spinner) findViewById(R.id.spin);
        myAdapter adapter = new myAdapter(getApplicationContext(), list,
                R.layout.list_layout, new String[] { "Name", "Icon" },
                new int[] { R.id.name, R.id.icon });

        spin.setAdapter(adapter);

    }

    private class myAdapter extends SimpleAdapter {

        public myAdapter(Context context, List<? extends Map<String, ?>> data,
                int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_layout,
                        null);
            }

            HashMap<String, Object> data = (HashMap<String, Object>) getItem(position);

            ((TextView) convertView.findViewById(R.id.name))
                    .setText((String) data.get("Name"));
            ((ImageView) convertView.findViewById(R.id.icon))
                    .setImageResource(R.drawable.icon);

            return convertView;
        }

    }