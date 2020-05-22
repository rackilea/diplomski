public void saveInfo()
    {
        SharedPreferences sharedPref = getSharedPreferences("weatherInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("currentTemp", temp.getText().toString());

        editor.apply();
    }

    public void displayData()
    {
        SharedPreferences sharedPref = getSharedPreferences("weatherInfo", Context.MODE_PRIVATE);

        String loadCurrentTemp = sharedPref.getString("currentTemp","");

        temp.setText(loadCurrentTemp);
    }