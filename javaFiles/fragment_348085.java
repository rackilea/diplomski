final Switch blue = (Switch) findViewById( R.id.blue );
        blue.setChecked( useBlueTheme );
        blue.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                toggleThemeBlue(isChecked);
                //toggleThemeBlue(false);
                toggleThemeGreen(false);
                toggleThemeOrange(false);
                toggleThemeRed(false);
                toggleThemeYellow(false);
            }
        } );
        final Switch green = (Switch) findViewById( R.id.green );
        green.setChecked( useGreenTheme );
        green.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                toggleThemeGreen(isChecked);
                toggleThemeBlue(false);
                //toggleThemeGreen(false);
                toggleThemeOrange(false);
                toggleThemeRed(false);
                toggleThemeYellow(false);
            }

        } );