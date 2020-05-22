@Override
    public void onBindViewHolder(final SearchViewHolder holder, int position) {
        holder.full_name.setText(fullNameList.get(position));
        holder.user_name.setText(userNameList.get(position));
        holder.user_id.setText(userIdList.get(position));
      Glide.with(context).load(profileImageList.get(position)).into(holder.profileImage);



 holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //for sending data UserProfile 
            Intent intent  = new Intent(context,UserProfile.class);
            intent.putExtra("USER_ID",String.valueOf(userIdList.get(position)));
            context.startActivity(intent);

            }
        });

    }