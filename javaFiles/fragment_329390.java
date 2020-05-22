@Override
public void onClick(View v) {
    Intent i = new Intent(v.getContext(), ShoeDetailActivity.class);
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    v.getContext().startActivity(i);
}