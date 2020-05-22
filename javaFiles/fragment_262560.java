@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
  String[] numbers_text = getResources().getStringArray(R.array.Planets);

  ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        inflater.getContext(), android.R.layout.simple_list_item_1,
        numbers_text);
  setListAdapter(adapter);
  return super.onCreateView(inflater, container, savedInstanceState);
}