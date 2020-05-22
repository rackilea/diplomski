runOnUiThread(new Runnable() {
    public void run() {
        try {
            textViewToChange.setText(mesto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});