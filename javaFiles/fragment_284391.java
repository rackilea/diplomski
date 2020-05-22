@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
              "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
              "Linux", "OS/2" };

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
    android.R.layout.simple_list_item_1, values);

    setListAdapter(adapter);
}