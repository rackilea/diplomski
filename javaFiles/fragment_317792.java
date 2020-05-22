crossImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Booking booking = bookings.get(getAdapterPosition());
                 datatype id = booking.getId();
                  removeAt(getAdapterPosition(),id);
            }
        });

public void removeAt(int position, dataType id) {
    bookings.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(position, bookings.size());

    DBHelper.delete(id);
}