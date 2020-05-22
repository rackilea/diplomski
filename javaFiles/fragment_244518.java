public class MainActivity extends ActionBarActivity {
    ImageView imgFavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
    public void imageClick(View view){
       imgFavorite =(ImageView)findViewById(R.id.imageView1);
        open();
    }
    public void open(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //IMAGE CAPTURE CODE
        startActivityForResult(intent, 0);
    }
     protected void onActivityResult(int requestCode,int resultCode,Intent data){
     super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap=(Bitmap)data.getExtras().get("data");
        imgFavorite.setImageBitmap(bitmap);
     }
}