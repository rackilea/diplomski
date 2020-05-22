private TextView resp = null;

FloatingActionButton button = (FloatingActionButton) findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String savedText = SomeMethod(); //the string used here is obtained through another method
        resp = (TextView) findViewById(R.id.TextOutput);
        resp.setText(savedText);
    }
});

public void exportPage() {
    String savedText = this.resp != null ? this.resp.getText().toString() : "";
    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, savedText);
    sendIntent.setType("text/plain");
    startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));
}