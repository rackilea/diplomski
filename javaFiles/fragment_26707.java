public View getView(final int position, View convertView, ViewGroup parent)
    {
        //creating the ViewHolder we defined earlier.
        final ViewHolder holder = new ViewHolder(); 

        //creating LayoutInflator for inflating the row layout.
        LayoutInflater inflator = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //inflating the row layout we defined earlier.
        convertView = inflator.inflate(R.layout.partylist, null);

        //setting the views into the ViewHolder.
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.voteUp = (CheckBox) convertView.findViewById(R.id.vote_up_image);
        holder.voteUp.setTag(position);
        holder.voteDown = (CheckBox) convertView.findViewById(R.id.vote_down_image);
        holder.voteDown.setTag(position);
        holder.votes = (TextView) convertView.findViewById(R.id.votes);




        //define an onClickListener for the ImageView.

        holder.voteUp.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (holder.voteUp.isSelected()){
                    holder.voteUp.setSelected(false);
                    list.get(position).Up=false;
                    holder.votes.setText(String.valueOf((list.get(position).votes)));
                } else {
                    if (holder.voteDown.isSelected()){
                    holder.voteUp.setSelected(true);
                    holder.voteDown.setSelected(false);
                    list.get(position).Up=true;
                    list.get(position).Down=false;
                    holder.votes.setText(String.valueOf((list.get(position).votes+1)));
                    }else{
                        holder.voteUp.setSelected(true);
                        list.get(position).Up=true;
                        holder.votes.setText(String.valueOf((list.get(position).votes+1)));
                    }

            }}
        });

        holder.voteDown.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {// Toast.makeText(PartyActivity.this, "Image from row " + position + " was pressed " + list.get(position).title, Toast.LENGTH_LONG).show();
                if (holder.voteDown.isSelected()){
                    holder.voteDown.setSelected(false);
                    list.get(position).Down=false;
                    holder.votes.setText(String.valueOf((list.get(position).votes)));
                } else {
                    if (holder.voteUp.isSelected()){
                    holder.voteDown.setSelected(true);
                    holder.voteUp.setSelected(false);
                    list.get(position).Down=true;
                    list.get(position).Up=false;
                    holder.votes.setText(String.valueOf((list.get(position).votes-1)));
                    }else{
                        holder.voteDown.setSelected(true);
                        list.get(position).Down=true;
                        holder.votes.setText(String.valueOf((list.get(position).votes-1)));
                    }

            }}
        }); 


        //setting data into the the ViewHolder.
        holder.title.setText(list.get(position).title);
        holder.votes.setText(String.valueOf(list.get(position).votes));
        holder.voteUp.setChecked(list.get(position).Up);
        holder.voteDown.setChecked(list.get(position).Down);
        //return the row view.
        return convertView;
    }