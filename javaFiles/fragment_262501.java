@Override
public void onBackPressed()
{
    super.onBackPressed(); 
    startActivity(new Intent(YourCurrentActivity.this, MainActivity.class));
    finish();
}