public class HomeActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            //Here Adapter like
            AdapterDemoGrid adapterDemoGrid  = new AdapterDemoGrid(this);
            gridView.setAdapter(adapterDemoGrid);

        }
    }