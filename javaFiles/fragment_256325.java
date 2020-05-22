Intent i = new Intent(Intent.ACTION_VIEW);

uri u = Uri.parse(websiteText.getText().toString());

i.setData(u);

try {
    startActivity(i);
} catch (ActivityNotFoundException e) {
    Toast.makeText(PassEdit.this, R.string.invalid_website, Toast.LENGTH_SHORT).show();
}