SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (sharedPreferences.getBoolean("startFromSecondActivity", false))
        {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();
        }