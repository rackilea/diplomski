public View getView(int position, View convertView, ViewGroup parent) {

      View vi = convertView;
      final ActivityTable act = actList.get(position);
      Holder holder;
      if (vi == null) {
       vi = inflater.inflate(R.layout.feed_single_picture, null, false);
       holder = new Holder();
       holder.likebtn = (ImageButton)convertView.findViewById(R.id.buttonId);
       vi .setTag(holder); // setting Holder as arbitrary object for row
      } else { // view recycling
       // row already contains Holder object
       holder = (Holder) vi .getTag();
     }



      holder.likebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                 //Send like
                   **here you can check the position**
           }

           //More code
          return vi;
    }