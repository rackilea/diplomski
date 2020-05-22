private String[] nums= { "One", "Two", "Three" };
private String[] names= { "HoneyComb", "JellyBean", "ICS" };


List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<nums.lenght();i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt1",  nums[i]);
            hm.put("txt2", names[i]);
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "txt1","txt2" };

        // Ids of views in listview_layout
        int[] to = {R.id.txt1,R.id.txt2};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);