import android.content.Intent;
    import android.graphics.PixelFormat;
    import android.net.Uri;
    import android.os.Build;
    import android.os.Bundle;

    import android.provider.Settings;
    import android.support.v7.app.AppCompatActivity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.WindowManager;
    import android.widget.Toast;

    import com.txusballesteros.bubbles.BubbleLayout;
    import com.txusballesteros.bubbles.BubblesManager;
    import com.txusballesteros.bubbles.OnInitializedCallback;
    /**
     * Created by yohanson on 20/09/17.
     */

    public class MainActivity extends AppCompatActivity {

        private BubblesManager bubblesManager;
        private WindowManager windowManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkDrawOverlayPermission();


                }
            });
        }


public void checkDrawOverlayPermission() {
    /** check if we already  have permission to draw over other apps */
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (!Settings.canDrawOverlays(this)) {
            /** if not construct intent to request permission */
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            /** request permission via start activity for result */
            startActivityForResult(intent, 2);
        }
        else
        {
            initializeBubblesManager();
            addNewBubble();

        }
    }
}
        @Override
        protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
            /** check if received result code
             is equal our requested code for draw permission  */
            if (requestCode == 2) {
                initializeBubblesManager();
                addNewBubble();

            }
        }

        private void addNewBubble() {


            windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
            //here is all the science of params
            final WindowManager.LayoutParams myParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.WRAP_CONTENT,
                    WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                            | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                            | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                    PixelFormat.TRANSLUCENT
            );
            BubbleLayout bubbleView = (BubbleLayout)LayoutInflater.from(MainActivity.this).inflate(R.layout.bubble_layout, null);
            bubbleView.setLayoutParams(myParams);

            bubbleView.setOnBubbleRemoveListener(new BubbleLayout.OnBubbleRemoveListener() {
                @Override
                public void onBubbleRemoved(BubbleLayout bubble) { }
            });
            bubbleView.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {

                @Override
                public void onBubbleClick(BubbleLayout bubble) {
                    Toast.makeText(getApplicationContext(), "Clicked !",
                            Toast.LENGTH_SHORT).show();
                }
            });
            bubbleView.setShouldStickToWall(true);
            bubblesManager.addBubble(bubbleView, 60, 20);
        }

        private void initializeBubblesManager() {
            bubblesManager = new BubblesManager.Builder(this)
                    .setTrashLayout(R.layout.bubble_trash_layout)
                    .setInitializationCallback(new OnInitializedCallback() {
                        @Override
                        public void onInitialized() {
                            addNewBubble();
                        }
                    })
                    .build();
            bubblesManager.initialize();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            bubblesManager.recycle();
        }
    }