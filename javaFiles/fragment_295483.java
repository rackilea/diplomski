public class ViewHolder extends RecyclerView.ViewHolder{

    LikeButton likeButton;
    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;

    public ViewHolder(View v){
    super(v);
    img = (ImageView) v.findViewById(R.id.imgview1);
    likeButton = (LikeButton) v.findViewById(R.id.cvcv);
    tx3 = (TextView)v.findViewById(R.id.counttxt);



    }
}