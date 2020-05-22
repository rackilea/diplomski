AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
GridView gridView = new GridView(getActivity());

ArrayList<GridViewItem>  mList = new ArrayList<GridViewItem>();

mList.add(new GridViewItem(R.drawable.ic_img1));
mList.add(new GridViewItem(R.drawable.ic_img2));
:
mList.add(new GridViewItem(R.drawable.ic_img9));
mList.add(new GridViewItem(R.drawable.ic_img10));

ImageAdapter iconItems = new ImageAdapter(getActivity(), mList);

gridView.setAdapter(iconItems);
gridView.setNumColumns(4);               // Number of columns
gridView.setChoiceMode(GridView.CHOICE_MODE_SINGLE);       // Choice mode
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // do something here
        Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();
        iconDialog.dismiss(); // Dismiss dialog after click on item
    }
});
builder.setView(gridView);
builder.setTitle("Select an icon");
iconDialog = builder.create();
iconDialog.show();