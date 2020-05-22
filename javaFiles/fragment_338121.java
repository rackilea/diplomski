private View mMainView;

@Override
protected void onCreate(Bundle arg0) {
    super.onCreate(arg0);
    mMainView = getLayoutInflater().inflate(R.layout.activity_app_share, null);
    setContentView(mMainView);
}

public void fillTextView(View view,int resId, String text)
{
   TextView textElement = (TextView) view.findViewById(resId);
   textElement.setText(text);
}