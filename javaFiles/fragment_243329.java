public class Publish_Event extends Activity{
    private static final int SELECT_PICTURE_1 = 1;
    private static final int SELECT_PICTURE_2 = 2;
    private static final int SELECT_PICTURE_3 = 3;

    protected void onCreate(Bundle savedInstanceState) {
        imagebutton1.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.setType("image/*");
               intent.setAction(Intent.ACTION_GET_CONTENT);
               startActivityForResult(Intent.createChooser(intent, "Choose a picture"), SELECT_PICTURE_1);
           }
        });
        imagebutton2.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.setType("image/*");
               intent.setAction(Intent.ACTION_GET_CONTENT);
               startActivityForResult(Intent.createChooser(intent, "Choose a picture"), SELECT_PICTURE_2);
           }
        });
   }

   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
       if (resultCode == Activity.RESULT_OK) {
          if (requestCode == SELECT_PICTURE_1) {
              //change imagebutton1
          }else if(requestCode == SELECT_PICTURE_2){
             //change imagebutton2 
          }else if(requestCode == SELECT_PICTURE_3){
             //change imagebutton3
          }
       }
   }