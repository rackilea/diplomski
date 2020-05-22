@Override
public void onPause() {
    getActivity().unregisterReceiver(newGameServiceReceiver);
    super.onPause();

}