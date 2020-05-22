public class MainActivity extends ListActivity {

    String item;

    DownloadXML a = new DownloadXML();
    a.data(); //This won't work. Put it inside a method

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        //...
    }