mNextBtn.setOnClickListener(new OnClickListener() {
    int i = 0;
    public void onClick(View v) {
        mSCanvas.setBackgroundResource(myImageList[i]);
        i++;
        if(i >= myImageList.length)
             i = 0;

        // I'm not sure what you want to do here, so I left it:
        mNextBtn.setEnabled(mSCanvas.isUndoable());
        return;
    }
});