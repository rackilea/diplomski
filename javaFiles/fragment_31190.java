@Override
public boolean onLongClick(View v) {
    // TODO Auto-generated method stub

    holdingDown = true;

    new Thread(new Runnable() {
        @Override
        public void run() {

            if (holdingDown) {
                int test = 0;
                test++;
                Log.i("test", test + "");
            } else {
                Log.i("test", "else");
            }
                return;

        }
    }).start();

    return false;
}