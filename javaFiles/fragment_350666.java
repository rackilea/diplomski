public static class ViewHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    ImageView imageView;
    TextView textView;

    public ViewHolder(CardView v){
        super(v);
        cardView = v;
        imageView = (ImageView) cardView.findViewById(R.id.list_icon);
        textView = (TextView) cardView.findViewById(R.id.card_text);
    }
}