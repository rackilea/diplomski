@Override
public void onDestroy() {
    super.onDestroy();

    timer.cancel();
    connectTask3.cancel(true);

}