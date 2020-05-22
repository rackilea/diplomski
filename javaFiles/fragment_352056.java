final AlertDialog.Builder builder;
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
    builder = new AlertDialog.Builder(this);
} else {
    builder = new AlertDialog.Builder(this,R.style.JumpDialog);
}