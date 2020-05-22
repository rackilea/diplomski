@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate( R.layout.list_row_layout, parent, false);
        if (position == 0) {
            //insert custom header layout into adapter 
        }else { //load the rest of your items
}