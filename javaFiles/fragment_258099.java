protected void fix(View child, String thetag, String value) {
        if (child == null)
            return;

        if (child instanceof ViewGroup) {
            fix((ViewGroup) child, thetag, value);
        }
        else if (child instanceof TextView) {
            doFix((TextView) child, thetag, value);
        }
    }

    private void fix(ViewGroup parent, String thetag, String value) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            fix(parent.getChildAt(i), thetag, value);
        }
    }
    private void doFix(TextView child, String thetag, String value) {
        if(child.getTag()!=null && child.getTag().getClass() == String.class) {
            String tag= (String) child.getTag();
            if(tag.equals(thetag)) {
                child.setText(value);
            }
        }
    }