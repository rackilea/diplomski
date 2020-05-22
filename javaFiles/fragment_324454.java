@Override
protected void onCreate(Bundle savedInstanceState)
{
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    LayoutInflater inflater = (LayoutInflater) this
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View contentView = inflater.inflate(R.layout.help, null, false);
    mDrawer.addView(contentView, 0); 
}