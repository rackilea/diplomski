ArrayList<Item> imageArry = new ArrayList<Item>();
CustomAdapter adapter;
ListView dataList;


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.activity_gallery, parent, false);
dataList = (ListView) v.findViewById(R.id.lista);

adapter = new CustomAdapter(getActivity(),R.layout.list,imageArry);
dataList.setAdapter(adapter);

return v;
}
.....

public void CreateNewListRow(){
imageArry.add(new Item(R.drawable.ek_logo,name));
imageArry.add(new Item(R.drawable.ek_logo,name));
imageArry.add(new Item(R.drawable.ek_logo,name));
imageArry.add(new Item(R.drawable.ek_logo,name));
imageArry.add(new Item(R.drawable.ek_logo,name));
adapter.notifyDataSetChanged();
}