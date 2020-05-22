public View getView(int position, View convertView, ViewGroup parent) {
        //ImageView imageView;
        Button btn;

        if (convertView == null) {  // if it's not recycled, initialize some attributes

            btn=new Button(mContext);
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                 }
             });
       //   imageView = new ImageView(mContext);

            btn.setLayoutParams(new GridView.LayoutParams(120,120));
        //  imageView.setLayoutParams(new GridView.LayoutParams(140,140));


            //imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            btn.setPadding(10,15, 10,15);
            btn.setImeActionLabel("hello",0);// actionId)

        //  imageView.setPadding(8,8, 8, 8);

        } else 
        {
            btn=(Button)convertView;
            //imageView=(ImageView)convertView;
        }
        btn.setBackgroundResource(mThumbIds[position]);
        //imageView.setImageResource(mThumbIds[position]);
        //return imageView;
        return btn;
    }