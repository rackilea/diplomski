package rajawali.tutorials;

import rajawali.RajawaliActivity;
import android.os.Bundle;

public class RajawaliTutorialActivity extends RajawaliActivity {

    public RajawaliTutorialRenderer mRenderer; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRenderer = new RajawaliTutorialRenderer(this);
        mRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mRenderer);
    }
}