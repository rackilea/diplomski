public class ViewHolder extends RecyclerView.ViewHolder {
    private final padding;

    public Message message;

    public RelativeLayout messageContainer;

    public TextView messageText;

    public ViewHolder(View v) {
        super(v);

        // Get the padding offset in pixels.
        Resources r = v.getContext().getResources();
        padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, r.getDisplayMetrics());

        messageContainer = (RelativeLayout) v.findViewById(R.id.messageContainer);

        messageText = (TextView) v.findViewById(R.id.messageText);
    }

    public void setMessage(Message message) {
        this.message = message;

        // Set the padding of the relativelayout.
        final depth = this.message.getDepth();
        messageContainer.setPadding(depth * 16, 0, 0, 0); // left, top, right, bottom
    }
}