@Override
public View getChildView(int groupPosition, int childPosition,
                        boolean isLastChild, View convertView, ViewGroup parent) {

    View view = convertView;
    convertView.setOnClickListener(new View.OnClickLister(){

        @override
        public void onClick(View v) {
            if (childPosition==1) {
                context.startActivity(...);
            }  
        });

    return view;
}