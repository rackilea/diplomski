public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

   ListView mDrawerListView = (ListView) rootView.findViewById(R.id.listView);
   mDrawerList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        final TypedArray typedArray = getResources().obtainTypedArray(R.array.sections_icons);
        mDrawerListView.setAdapter(new ArrayAdapter<String>(
                getActionBar().getThemedContext(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                getResources().getStringArray(R.array.sections)
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                int resourceId = typedArray.getResourceId(position, 0);
                Drawable drawable = getResources().getDrawable(resourceId);
                ((TextView) v).setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                return v;
            }
        });

        mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);
        return rootView;
    }