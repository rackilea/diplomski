public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public ImageView iconImageView;
    public TextView iconTextView;

    public MyViewHolder(final View itemView) {
        super(itemView);

        iconImageView = (ImageView) itemView.findViewById(R.id.myRecyclerImageView);
        iconTextView = (TextView) itemView.findViewById(R.id.myRecyclerTextView);
        // set click event
        itemView.setOnClickListener(this);
        iconTextView.setOnClickListener(this);
        // set long click event
        iconImageView.setOnLongClickListener(this);
    }

    // onClick Listener for view
    @Override
    public void onClick(View v) {    
        if (v.getId() == iconTextView.getId()) {
            Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }


    //onLongClickListener for view
    @Override
    public boolean onLongClick(View v) {    
        final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Hello Dialog")
            .setMessage("LONG CLICK DIALOG WINDOW FOR ICON " + String.valueOf(getAdapterPosition()))
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

        builder.create().show();
        return true;
    }
}