public class anotherActivity extends MainActivity{

private final String FILEPATH = "FinalPath";
String path;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstance);
    setContentView(R.layout.main);

    path = prefs.getString(FILEPATH, "");

    ImageButton imageButton = (ImageView) findViewById(R.id.imgBtn);
    imageButton.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(path)));

}

}