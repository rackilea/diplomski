@Override
protected void onActivityResult(final int requestCode,
                                final int resultCode,
                                final Intent data) {
    if (resultCode == RESULT_OK) {
        switch (requestCode) {
            case SHOW_DETAILS_REQUEST: {
                //select mapfragment as current, assuming it is at index 0
                viewpager.setCurrentItem(0);
                //add your zoom logic here in zoomToCenter method
                mapfragment.zoomToCenter(data.getStringExtra("lat"),data.getStringExtra("lon"));
            }
        }
    }
    super.onActivityResult(requestCode, resultCode, data);
}