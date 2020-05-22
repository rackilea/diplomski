public class MainActivity extends Activity implements PickTime{

        EditFragment newFragment; 
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            newFragment = new EditFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, newFragment);
            //transaction.addToBackStack(null);
            transaction.commit();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public void returnTime(String value) {
            // TODO Auto-generated method stub
            if(newFragment.isVisible())
            {
                newFragment.setEdittextvalue(value);
            }

        }

    }