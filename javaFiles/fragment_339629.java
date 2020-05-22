public class PinballShooterActivity extends Activity {

    ...

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        ourSong.release();
        finish();
        }
    }

    ...

}