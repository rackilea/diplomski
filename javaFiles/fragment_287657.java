@Override

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mainImage.setImageResource(list.get(position).getMainImage());
        holder.fullName.setText(list.get(position).getFullName());
        holder.description.setText(list.get(position).getDescription());
        holder.historyImage.setImageResource(list.get(position).getHistoryIcon());
        holder.date.setText(list.get(position).getDate());

        holder.call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Toast.makeText(getActivity(), "Whom you wanna call?", Toast.LENGTH_SHORT).show();
                }
           });

        holder.sms.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Whom you wanna send sms?",                                }
            });

    }