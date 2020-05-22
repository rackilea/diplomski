if(likeable.get(i) == 0) {
    LinearLayout btn = (LinearLayout) row.findViewById(R.id.btn_like);
    btn.setClickable(false);
    ImageView imgView = (ImageView) row.findViewById(R.id.img_like);
    imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_like_selected));
    TextView txtView = (TextView) row.findViewById(R.id.text_like);
    txtView.setTextColor(Color.parseColor("#60007c"));
} else {
    LinearLayout btn = (LinearLayout) row.findViewById(R.id.btn_like);
    btn.setClickable(true);
    ImageView imgView = (ImageView) row.findViewById(R.id.img_like);
    imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_like));
    TextView txtView = (TextView) row.findViewById(R.id.text_like);
    txtView.setTextColor(Color.parseColor("#555555"));
}
if(dislikeable.get(i) == 0) {
    LinearLayout btn = (LinearLayout) row.findViewById(R.id.btn_dislike);
    btn.setClickable(false);
    ImageView imgView = (ImageView) row.findViewById(R.id.img_dislike);
    imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_dislike_selected));
    TextView txtView = (TextView) row.findViewById(R.id.text_dislike);
    txtView.setTextColor(Color.parseColor("#60007c"));
} else {
    LinearLayout btn = (LinearLayout) row.findViewById(R.id.btn_dislike);
    btn.setClickable(true);
    ImageView imgView = (ImageView) row.findViewById(R.id.img_dislike);
    imgView.setImageDrawable(getResources().getDrawable(R.drawable.ic_dislike));
    TextView txtView = (TextView) row.findViewById(R.id.text_dislike);
    txtView.setTextColor(Color.parseColor("#555555"));
}