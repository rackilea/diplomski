public class FirstActivity extends Activity {
    private static final int PICK_COLOR_REQUEST = 1001;

    ...

    private void pickColor() {
        Intent pickColorIntent = new Intent(this, SecondActivity.class);
        startActivityForResult(pickColorIntent, PICK_COLOR_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_COLOR_REQUEST && resultCode == Activity.RESULT_OK) {
            int color = data.getIntExtra("color");
            /* use the color */
        }
    }
}

public class SecondActivity extends Activity {
    ...

    private void onColorPicked(int color) {
        Intent dataIntent = new Intent();
        dataIntent.putExtra("color", color);

        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}