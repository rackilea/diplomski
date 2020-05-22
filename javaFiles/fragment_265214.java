static float cowCount, income, cowMult;
...
protected void onResume()
{
    super.onResume();
    SharedPreferences sharedPref = getSharedPreferences("com.example.cowcount", Context.MODE_PRIVATE);
    cowCount = sharedPref.getFloat("cowCount", 197);
    cowMult = sharedPref.getFloat("cowMult", 1);
    income = sharedPref.getFloat("income", 0);
}
...