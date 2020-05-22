public class MainActivity extends AppCompatActivity {

    private BackPressListener backPressListener;

    public void setBackPressListener(BackPressListener backPressListener) {
        this.backPressListener = backPressListener;
    }

    @Override
    public void onBackPressed() {
        if (backPressListener != null)
            backPressListener.onBackPressed();
        else super.onBackPressed();
    }
}