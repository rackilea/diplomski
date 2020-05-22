@Override
        public void onBindViewHolder(MyViewHolder holder,  int position) {

            Build build = buildList.get(position);

            holder.imageView.setImageResources(build.getImages());

            holder.name.setText(build.getName());
            setImageIntoButton(holder.button,build.isSelected());

            holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        build.setSelected(!build.isSelected());
                        setImageIntoButton(holder.button,build.isSelected());
                    }
                });
        }

      private void setImageIntoButton(Button buttonView,boolean isSelected){
         if(isSelected)
           buttonView.setBackgroundResource(R.drawable.clicked_image); 
            else 
          buttonView.setBackgroundResource(R.drawable.cross_image); 
 }