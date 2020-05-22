ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
    toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Shower_fragment shower_fragment = new Shower_fragment();
            android.app.FragmentManager fragmentManager = getFragmentManager();

            if( null == fragmentManager){
                Toast.makeText(getApplication(), "Null Fragment Manager", Toast.LENGTH_LONG).show();
                return;}

            if(isChecked){
                Toast.makeText(getApplication(),"If Clicked", LENGTH_SHORT).show();
                fragmentManager.beginTransaction()
                        .add(R.id.linear_shower, shower_fragment, "Shower")
                        .show(shower_fragment)
                        .commit();
            }else{
                Toast.makeText(getApplication(), "Else Clicked", LENGTH_SHORT).show();
                Shower_fragment shower_fragmentElse = (Shower_fragment) fragmentManager.findFragmentByTag("Shower");
                fragmentManager.beginTransaction()
                        .hide(shower_fragmentElse)
                        .commit();
            }
        }
    });