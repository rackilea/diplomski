@Override
public void onBackPressed()
{
    startActivity(new Intent(timer_2.this, timer_2_pause.class));
    finish();
}