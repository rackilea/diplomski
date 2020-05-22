private Handler handler = new Handler() {

    @SuppressWarnings("unchecked")
    @Override
    public void handleMessage(Message m) {
        pd.dismiss();
        String message = (String)m.object;
        if(message.equals("1")) {
            Toast.makeText(getApplicationContext(), "Do a scan first", Toast.LENGTH_SHORT).show(); 
        }
    }
};