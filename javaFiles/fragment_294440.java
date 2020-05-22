public void someFunction(View v)
{
    Button btn = (Button)v;  
    switch (v.getId())
    {
       case (R.id.wifi_on:
        setWifiOn(btn);
        break;
       case (R.id.differentBtnId):
       // do some other things
       break;
     }
}

}