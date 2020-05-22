final int unread = Neoseeker.this.neoApi.getPmUnread();
Main.this.runOnUiThread(new Runnable() {

    public void run() {

        Toast.makeText(Main.this, "new: " + unread, Toast.LENGTH_SHORT).show();
        Neoseeker.this.text.setText("this is the text! " + unread);

    }

});