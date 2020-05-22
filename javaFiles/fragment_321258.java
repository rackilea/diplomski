reducedFunction(int numRows, int numImages, bool[][] tracker) {
    for (i = 0; i < numRows; i++) {
        for (j = 0; j < numImages; j++) {
            imageView[j].setOnClickListener(new OnClickListener(){
                public void onClick(View v) {
                    if (tracker[i-1][j-1] == false) {
                        tracker[i-1][j-1] = true;
                        v.setBackgroundResource(R.drawable.launcher);
                    } else {
                        tracker[i-1][j-1] = false;
                        v.setBackgroundResource(R.drawable.icon);
                    }
        }
    }
}

if(screenWidth > screenHeight) {
    reducedFunction(numLandscapeRows, numLandscapeImagesPerRow, imageViewLandscapeTracker)
}
else {
    reducedFunction(numPortraitRows, numPortraitImagesPerRow, imageViewPortraitTracker)
}