Handler handler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case PASS:
            String obj = msg.obj.toString();
            Toast.makeText(YourActivity.this, "PASS",
                    Toast.LENGTH_SHORT).show();
            break;
        case FAIL:
            Toast.makeText(YourActivity.this, "FAIL",
                    Toast.LENGTH_SHORT).show();
            break;
        }
    }
};