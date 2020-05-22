@Override
public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {

    Review review = the_reviews.get(position);

    int pubOrPriv = review.getPublicOrPrivate();

    //shared_status will be Just U, Private or Public
    String shared_status = "";

    if (pubOrPriv == 0) {
        //change colour depending on value
        ((ReviewHolder) viewHolder).phone_user_name.setTextColor(Color.parseColor("#DA850B"));
        shared_status = "Just U";
    }

    if (pubOrPriv == 1) {
        ((ReviewHolder) viewHolder).phone_user_name.setTextColor(Color.parseColor("#0A7FDA"));
        shared_status = "Private";
    }

    if (pubOrPriv == 2) {
        ((ReviewHolder) viewHolder).phone_user_name.setTextColor(Color.parseColor("#2AB40E"));
        shared_status = "Public";

    }

    //.............
}