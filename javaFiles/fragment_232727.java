//method to convert from dp to px
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = SignUp.this.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));       
        return px;
    }