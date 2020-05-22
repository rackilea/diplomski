@Override
public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {

    //Rest of onBindViewHolder code

    holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(final View v) {
            final int pos = holder.getAdapterPosition();

            AlertDialog.Builder adb = new AlertDialog.Builder(v.getContext());
            CharSequence meni[] = new CharSequence[] {"DOING"};
            adb.setItems(meni, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 0) {
                    mValues.get(pos).setStanje("doing");
                    clickLinster_.onLongClick(mValues.get(pos).getId_(),mValues.get(pos).getStanje());
                }
                }
            });
            AlertDialog alertDialog = adb.create();
            alertDialog.setCancelable(true);
            alertDialog.show();
            return true;
        }
    });

}