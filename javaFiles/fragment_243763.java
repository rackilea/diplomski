class WifiReceiver extends BroadcastReceiver
{
    public void onReceive(Context c, Intent intent)
    {
        sb = new StringBuilder();
        wifiList = mainWifi.getScanResults();
        for(int i = 0; i < wifiList.size(); i++)
            wifiData.add(Integer.toString(i + 1) + "." + (wifiList.get(i)).toString());
        wifiData.add("Bite");
        adapter.notifyDataSetChanged();
    }
}