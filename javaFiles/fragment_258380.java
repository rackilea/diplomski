@CoordinatorLayout.DefaultBehavior(CustomView.Behavior.class)
public class CustomView extends View {
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public static class Behavior extends CoordinatorLayout.Behavior<CustomView> {

        public Behavior() {
            super();
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams lp) {
            if (lp.dodgeInsetEdges == Gravity.NO_GRAVITY) {
                // This setting makes it works (learn from FloatingActionButton.Behavior)
                lp.dodgeInsetEdges = Gravity.BOTTOM;
            }
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, CustomView child,
                                              View dependency) {
            return false;
        }
    }
}