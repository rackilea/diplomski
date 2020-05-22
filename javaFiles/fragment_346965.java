@Override
public void onClick(View v) {
    // TODO Auto-generated method stub

    switch (v.getId()) {
    case R.id.button_start_pause:
        ready();
        set();
        go();
        break;

    default:
        break;
    }

}

public void ready() {
    text_timer.setText("Ready");
}


public void set() {
    final Handler handler = new Handler();

    final Runnable r = new Runnable() {
        public void run() {
            text_timer.setText("   Set  ");

        }
    };
    handler.postDelayed(r, 1000);
}

public void go() {
    final Handler handler = new Handler();

    final Runnable r = new Runnable() {
        public void run() {
            text_timer.setText("  Go!!! ");

        }
    };
    handler.postDelayed(r, 2000);
}