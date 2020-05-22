private class ReceiverThread extends Thread {
@Override
public void run() { 
Activity_name.this.runOnUiThread(new Runnable() {

        @Override
        public void run() {
             mAdapter.notifyDataSetChanged();
        }
    });
}