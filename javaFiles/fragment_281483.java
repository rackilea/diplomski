private class MyAdapter extends ArrayAdapter {

    ...

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        v.setBackgroundColor(position % 2 == 0 : 0xff000000, 0xffffffff);
    }
}