@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK && requestCode == "some request tag") {
        String text = getStringExtra("textInput);
    }
}