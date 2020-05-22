public class CustomOnClickListener implements View.OnClickListener{

 private Context appContext;
 public CustomOnClickListener(Context context)
 {
    appContext = context;
 }

 @Override
 public void onClick(View arg0) {
   switch(arg0.getId())
   {
    case R.id.button1:
    // There is "Off" button On UI. Onclick event of the button, this function
    // is called. 
    break;
   }

  }
}