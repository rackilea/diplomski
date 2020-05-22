public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
 if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_view_inspection, null);
        }

 view.setOnLongClickListener(new OnLongClickListener() {    
                    @Override
                    public boolean onLongClick(View v) {
                        Dialog(param 1, param2); //your alert box method or something
                        return true;
                    }
                });
}