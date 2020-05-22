lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent i = new Intent(getApplicationContext(), StopIdResultsActivity.class);

            GetStopId getstopid_fromclass = list[position];


            //Create the bundle
            Bundle bundle = new Bundle();

            //Add your data to bundle
            bundle.putString("stopid", getstopid_fromclass.getStopid());

            //Add the bundle to the intent
            i.putExtras(bundle);

            //Fire that second activity
            startActivity(i);
        }

    })