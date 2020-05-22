public class RevToolBar
{
Context mContext;
public RevToolBar(Context context){
    mContext = context;
  }
public Toolbar getRevToolbar() {
    Toolbar toolbar = new Toolbar(mContext);
    LinearLayout.LayoutParams toolBarParams = new LinearLayout.LayoutParams(
            Toolbar.LayoutParams.MATCH_PARENT,
            150
    );
    toolbar.setLayoutParams(toolBarParams);
    toolbar.setBackgroundColor(Color.BLUE);
    toolbar.setVisibility(View.VISIBLE);
    return toolbar;
   }
}