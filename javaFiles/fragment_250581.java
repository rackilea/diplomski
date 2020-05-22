Runnable SendThread = new Runnable() {
    public void run() {
        try {
            GetAndConvertImagesToPdf();
            mProgStatus = 30;
            mProgress.setProgress(mProgStatus);
            title.setText(R.string.sendingTitle);
        } 
        catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
};