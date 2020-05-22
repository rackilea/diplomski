public static void FadeIn(final ImageView v,
        final int begin_alpha, final int end_alpha, int time,
        final boolean toggleVisibility) {

    if (Integer.valueOf(android.os.Build.VERSION.SDK_INT) >= android.os.Build.VERSION_CODES.JELLY_BEAN)
        v.setImageAlpha(begin_alpha);
    else
        v.setAlpha(begin_alpha);

    if (toggleVisibility) {
        if (v.getVisibility() == View.GONE)
            v.setVisibility(View.VISIBLE);
        else
            v.setVisibility(View.GONE);
    }

    Animation a = new Animation() {
        @Override
        protected void applyTransformation(float interpolatedTime,
                Transformation t) {
            if (interpolatedTime == 1) {
                if (Integer.valueOf(android.os.Build.VERSION.SDK_INT) >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                    v.setImageAlpha(end_alpha);
                else
                    v.setAlpha(end_alpha);

                if (toggleVisibility) {
                    if (v.getVisibility() == View.GONE)
                        v.setVisibility(View.VISIBLE);
                    else
                        v.setVisibility(View.GONE);
                }
            } else {
                int new_alpha = (int) (begin_alpha + (interpolatedTime * (end_alpha - begin_alpha)));
                if (Integer.valueOf(android.os.Build.VERSION.SDK_INT) >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                    v.setImageAlpha(new_alpha);
                else
                    v.setAlpha(new_alpha);
                v.requestLayout();
            }
        }

        @Override
        public boolean willChangeBounds() {
            return true;
        }
    };

    a.setDuration(time);
    v.startAnimation(a);
}