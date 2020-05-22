@Override
protected void onPause() {
    super.onPause();
    wl.release();
    }
}//End of onPause


@Override
protected void onResume() {
    super.onResume();
    wl.acquire();
}//End of onResume