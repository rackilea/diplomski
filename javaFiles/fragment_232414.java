public class MainActivity extends ListActivity {

            String item; 

           @Override
            protected void onCreate(Bundle savedInstanceState) {
                //...
                DownloadXML a = new DownloadXML();
                a.data(); 
            }
}