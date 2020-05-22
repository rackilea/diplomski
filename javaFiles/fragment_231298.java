@Override
protected void onStop() {
    super.onStop();
    if (mp != null) {
     mp.reset();
     mp.release();
     mp = null;
    }
    if (mp2 != null) {
     mp2.reset();
     mp2.release();
     mp2 = null;
    }
}