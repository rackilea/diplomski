public static class PicturesHolder extends RecyclerView.ViewHolder {
    Context ctx;
    ImageView image;

    public PicturesHolder(View v) {
        super(v);
        this.ctx = v.getContext();
        this.image = (ImageView) v.findViewById(R.id.myImageView);
    }

    public void setImage(String url) {
        Glide.with(ctx)
                .load(url)
                .into(image);
    }
}