private boolean[] myChecks = new boolean[myItems.length];
private class MyAdapter extends ArrayAdapter<String> {
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ...
        shareToggle.setChecked(myChecks[position]);
        shareToggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                ...
                myChecks[position] = arg1;
            }
        });
}