public class CustomPagerAdapter extends Your_adapter_method {
 private Context context; 

 public CustomPagerAdapter(Context context) {
      this.context = context;     //Main Activity Context
 }

 public View getView(...){
     View v;
     v.setOnClickListener(new OnClickListener() {
         void onClick() {
              Intent intent= new Intent(context, secondactivity.class);
              intent.putextra("your_extra","your_class_value");
              context.startActivity(intent); //Must use context to start activity.
         }
     });
 }
}