import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

public class ActivitySlider {

    private final FragmentActivity activity;
    private final View content;

    public ActivitySlider(FragmentActivity activity) {
        this.activity = activity;

        // Here we get the content View from the Activity.
        this.content = (View) activity.findViewById(android.R.id.content).getParent();
    }

    public void slideTo(int x, int y) {

        // We get the current position of the Activity
        final int currentX = getActivityPositionX();
        final int currentY = getActivityPositionY();

        // The new position is set
        setActivityPosition(x, y);

        // We animate the Activity to slide from its previous position to its new position
        TranslateAnimation animation = new TranslateAnimation(currentX - x, 0, currentY - y, 0);
        animation.setDuration(500);
        this.content.startAnimation(animation);
    }

    public void setActivityPosition(int x, int y) {
        // With this if statement we can check if the devices API level is above Honeycomb or below
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // On Honeycomb or above we set a margin
            FrameLayout.LayoutParams contentParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
            contentParams.setMargins(x, y, -x, -y);
            this.content.setLayoutParams(contentParams);
        } else {
            // And on devices below Honeycomb we set a padding
            this.content.setPadding(x, y, -x, -y);
        }
    }

    public int getActivityPositionX() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // On Honeycomb or above we return the left margin
            FrameLayout.LayoutParams contentParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
            return contentParams.leftMargin;
        } else {
            // On devices below Honeycomb we return the left padding
            return this.content.getPaddingLeft();
        }
    }

    public int getActivityPositionY() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // On Honeycomb or above we return the top margin
            FrameLayout.LayoutParams contentParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
            return contentParams.topMargin;
        } else {
            // On devices below Honeycomb we return the top padding
            return this.content.getPaddingTop();
        }
    }
}