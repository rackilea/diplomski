private void setNextImage() {
    showPic++;
    if (showPic == ids.length) {
        showPic = 0;
    }
    slide.setImageResource(ids[showPic]);
    handler.postDelayed(imageUpdate, 1000);
}