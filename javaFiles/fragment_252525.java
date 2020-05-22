SharedPreferences preferences = this.getSharedPreferences("SoldiPreferences", Context.MODE_PRIVATE);
preferences.getBoolean("storevalue", false);

if(preferences.getBoolean("storevalue", false))
{
view.setVisibility(View.VISIBLE);
}
else
view.setVisibility(View.GONE);