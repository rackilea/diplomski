@Override
public void onDestroy ()
{
    try {
    unregisterReceiver (broadcastReceiver);
    }
    catch (IllegalArgumentException e){}
    catch (NullPointerException ne){}
    super.onDestroy();
}