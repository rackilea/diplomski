SharedPreferences sharedPreferences = getSharedPreferences("YOUR PREF KEY", Context.MODE_PRIVATE);
Calendar c = Calendar.getInstance();

        int thisDay = c.get(Calendar.DAY_OF_YEAR); // GET THE CURRENT DAY OF THE YEAR

        int lastDay = sharedPreferences.getInt("YOUR DATE PREF KEY", 0); //If we don't have a saved value, use 0.

        int counterOfConsecutiveDays = sharedPreferences.getInt("YOUR COUNTER PREF KEY", 0); //If we don't have a saved value, use 0.

if(lastDay == thisDay -1){
    // CONSECUTIVE DAYS
    counterOfConsecutiveDays = counterOfConsecutiveDays + 1;

    sharedPreferences.edit.putInt("YOUR DATE PREF KEY", thisDay);

    sharedPreferences.edit.putInt("YOUR COUNTER PREF KEY", counterOfConsecutiveDays).commit;
} else {

    sharedPreferences.edit.putInt("YOUR DATE PREF KEY", thisDay);

    sharedPreferences.edit.putInt("YOUR COUNTER PREF KEY", 1).commit();
}