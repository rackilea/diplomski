@Override
public void onBindViewHolder(@NonNull final UsersViewHolders holder, final int position) {
    holder.itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            mListener.OnItemClickListener(holder, position);

        }

    });
}