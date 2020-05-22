@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch( position )
            {
                case 0:  Intent newActivity = new Intent(MainActivity.this, Ahri.class);
                    startActivity(newActivity);
                    break;

                case 1:  Intent newActivity2 = new Intent(MainActivity.this, Aatrox.class);
                    startActivity(newActivity2);
                    break;

            }