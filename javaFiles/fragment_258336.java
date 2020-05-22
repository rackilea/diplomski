// Have your Activity implement the GameEventListener interface
public class MyActivity extends Activity implements GameEventListener {
    public void onClick(View view) {
        if (R.id.button = view.getId()) {
            MainView mainView = new MainView(this);
            mainView.setBackgroundColor(Color.BLACK);

            // Since your Activity implements this interface, you can just
            // set `this` as the listener. Whenever your MainView class
            // calls one of the notify() methods, the implementations below
            // will be triggered.
            mainView.setGameListener(this);
            setContentView(mainView);
        }
    }

    @Override public void onWin() {
        // Reset your view here
    }

    @Override public void onLoss() {
        // Reset your view here
    }
}