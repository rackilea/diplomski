ListAdapter adapter = new SimpleAdapter(getActivity(), list, R.layout.list_rom_item, 
                  new String[] { TAG_NAME, TAG_SURNAME }, new int[] { R.id.name, R.id.surname}) {
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        ...
        return v;
    }
}