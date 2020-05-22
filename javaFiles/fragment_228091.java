@Override
public void onBindViewHolder(final Holder holder, int position) {
    holder.txvSongTitle.setText(sSongs[position].getTitle());
    holder.txvSongInfo.setText(sSongs[position].getArtists());

    if (!selectedSongs.contains(sSongs[position])) {
        holder.linearLayout.setBackgroundResource(android.R.color.transparent);
    }
    else {
        holder.linearLayout.setBackgroundResource(R.color.colorItemSelected);
    }

    holder.linearLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = holder.getAdapterPosition();System.out.println(sSongs[pos].getTitle());

            if (selectedSongs.contains(sSongs[pos])) {
                selectedSongs.remove(sSongs[pos]);

                holder.linearLayout.setBackgroundResource(android.R.color.transparent);
            }
            else {
                selectedSongs.add(sSongs[pos]);

                holder.linearLayout.setBackgroundResource(R.color.colorItemSelected);
            }
        }
    });
}