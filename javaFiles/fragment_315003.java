public class DrawerActivity extends Activity {

    public RelativeLayout fullLayout;
    public FrameLayout frameLayout;

    @Override
    public void setContentView(int layoutResID) {

        fullLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.drawer_n_activity, null);
        frameLayout = (FrameLayout) fullLayout.findViewById(R.id.drawer_frame);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);

        super.setContentView(fullLayout);

        //Your drawer content...

    }
}