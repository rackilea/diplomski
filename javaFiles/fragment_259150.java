@Override
public int getItemViewType(int position) {
    Object obj = callSMSFeed.get(position);

    if (obj instanceof Phonecall) {
        return R.layout.cardview_a;
    } else if (obj instanceof SMSmessage) {
        return R.layout.cardview_b;
    }

    throw new IllegalStateException("item at position " + position + " is not a Phonecall or SMSmessage: " + obj);
}