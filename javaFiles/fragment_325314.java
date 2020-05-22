public class updateStars() {
txt_stars = (TextView) findViewById(R.id.txtStars);
sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//the key is "Stars" don't forget to type it as you created the Sp
String stars = String.valueOf(sharedPreferences.getInt("Stars", 0));
txt_stars.setText(stars);
}