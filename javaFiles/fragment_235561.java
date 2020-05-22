long lastTimePressed=0L;

@Override
public void onBackPressed (){
    if(System.currentTimeMillis()-lastTimePressed>2000) //short Toast duration, now should be faded out
        finish();
    else
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

    lastTimePressed=System.currentTimeMillis();
}