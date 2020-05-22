protected void updateData(String data) {
    mMyEdit.post(
        new Runnable() {
            public void run() {
                mMyEdit.setText(data);
            }
        }
);
}