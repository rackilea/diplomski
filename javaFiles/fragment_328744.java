... MyClass {

    private MyArrayAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] names = new String[] { "name1", "name1", "name1" };
        String[] values = new String[] { "value1", "value2", "value3" };
        adapter = new MyArrayAdapter(getActivity(), names, values);
       setListAdapter(adapter);
    }

    // Another method
    private void myMethod() {
          adapter.notifyDataSetChanged();
    }
}