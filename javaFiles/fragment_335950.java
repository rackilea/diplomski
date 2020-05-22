holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent url = new Intent("url");
            url ("url_adapter",item.get(position).getURL());
            BroadcastHelper.sendInform(context,"url",url);
        }
    });