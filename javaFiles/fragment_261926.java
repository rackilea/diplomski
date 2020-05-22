public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row = convertView;
        if(row == null)
        {
        LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inf.inflate(R.layout.single_row , parent , false);
        }
        ImageView myImage = (ImageView) row.findViewById(R.id.imageView1);
        TextView tit = (TextView) row.findViewById(R.id.textView1);
        TextView des = (TextView) row.findViewById(R.id.textView2);
        myImage.setImageResource(image[position]);
        tit.setText(tit1[position]);
        des.setText(tit2[position]);
        row.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                  // Do your stuff here
            }
        });
        return row;
    }