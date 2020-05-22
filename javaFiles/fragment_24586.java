public class HandleListClick extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_handle_list_click);
            Intent intent = getIntent();
            int pos = intent.getIntExtra("POSITION",0);
            getItemPosition(pos);
        }


        public void getItemPosition(int position) {
            switch (position) {
                case 0:
                    Fragment6 frag6 = null;
                    frag6 = new Fragment6();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.framelayout, frag6)
                            .commit();


            }
        }
    }