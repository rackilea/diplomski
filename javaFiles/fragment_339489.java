@Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        background = (ImageView) holder.view.findViewById(R.id.image);
        layout = (LinearLayout) holder.view.findViewById(R.id.layout);

        delete = (ImageView) layout.findViewById(R.id.delete);
        lock = (ImageView) layout.findViewById(R.id.lock);


        delete.setTag("delete_"+position);
        lock.setTag("lock_"+position);

        if(Constants.demoDatas.get(position).isLiked()){
            delete.setImageResource(R.drawable.ic_launcher);
        }
        else{
            delete.setImageResource(android.R.drawable.ic_delete);
        }

        delete.setOnClickListener(new CustomClickListener(position));
        lock.setOnClickListener(new CustomClickListener(position));



    }