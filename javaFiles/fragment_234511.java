public void goChat(Context context)
{
    Log.v("GoChat", "Start");
    RelativeLayout mainLayout = (RelativeLayout)  ((Activity)context).findViewById(R.id.main_layout);
    LinearLayout ll = new LinearLayout(context);
    ll.setId(999);
    getFragmentManager().beginTransaction().add(ll.getId(), ChatFragment.newInstance()).commit();
    mainLayout.addView(ll);
}