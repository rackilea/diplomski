public class MyActivity extends Activity implements OnClickListener{
 protected void onCreate(Bundle bundle) {
    //Usual Activity Stuff
    View v = (View)findViewById(R.id.view); 
    v.setOnClickListener(this);
 }

 public void onClick(View v) {
  super.onClick(v);
  this.openContextMenu(v);
 }
}