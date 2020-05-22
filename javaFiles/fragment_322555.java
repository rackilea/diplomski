public class MyFragment extends Fragment{
      private BroadcastReceiver  refreshData = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
            myAdapter.notifyDataSetChanged();
      }
    };  
@Override
    public void onResume() {
        super.onResume();
    LocalBroadcastManager.getInstance(getContext()).registerReceiver(refreshData,
    new IntentFilter("refresh_Data"));  
    }
    @Override
    public void onPause() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(refreshData);
       super.onPause();
    }
    }