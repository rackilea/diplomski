@Override
public void onBackPressed() {
    String data = mEditText.getText();
    Intent intent = new Intent();
    intent.putExtra("MyData", data);
    setResult(resultcode, intent);
}