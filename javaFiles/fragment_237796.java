public class MyListAdapter extends SimpleListAdapter() {

    @Override
    public view getView(int position, View convertView, ViewGroup parent) {
        // let the superclass inflate our view for us
        View view = super.getView(position, convertView, parent);

        // attach a listener to our check box
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox1);
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity(), "row # " + position + " is checked", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "row # " + position + " is unchecked", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}