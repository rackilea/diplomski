@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    int viewType = holder.getItemViewType();

    switch (viewType) {
        case R.layout.cardview_a:
            Phonecall call = (Phonecall) callSMSFeed.get(position);
            ((CallViewHolder) holder).showCallDetails(call);
            break;

        case R.layout.cardview_b:
            SMSmessage sms = (SMSmessage) callSMSFeed.get(position);
            ((SMSViewHolder) holder).showSmsDetails(sms);
            break;

        default:
            throw new IllegalArgumentException("unexpected viewType: " + viewType);
    }
}