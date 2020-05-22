buttonStundeZuweisen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String FKZ = fachSpinnerText;
            String LKZ = lehrerSpinnerText;
            String RKZ = raumSpinnerText;
            Log.d(TAG, "" + ViewID + FKZ + LKZ + RKZ);
            //timeTableFragment.schreibeInArray(ViewID, FKZ,LKZ,RKZ);

            Intent returnIntent = new Intent();
            returnIntent.putExtra("result",(new String[]{FKZ, LKZ, RKZ}));
            setResult(Activity.RESULT_OK,returnIntent);
            finish();


            Toast.makeText(StundeZuweisen.this, "Stunde wurde zugewiesen.", Toast.LENGTH_LONG).show();

            /*boolean istGespeichert =  myDb.speicherStunde(ViewID, FKZ, LKZ , RKZ);
            if (istGespeichert == true){
                Toast.makeText(StundeZuweisen.this, "Stunde wurde zugewiesen.", Toast.LENGTH_LONG).show();
            }*/
        }
    });