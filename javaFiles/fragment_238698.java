class MyActivity extends Activity {
// some stuff

    public void showToast(String text, int duration) {
        Toast toast = Toast.makeText(this.getBaseContext(), text, duration);
        toast.show();
    }
}