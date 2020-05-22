private View.OnClickListener mConnectOnClick = new View.OnClickListener() {
@Override
public void onClick(View v) {
    Intent intent = new Intent(v.getContext(), Connectingreceiver.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    v.getContext().startActivity(intent);
}