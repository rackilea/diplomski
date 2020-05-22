if (0==position) {
    String url = "My-Site.com";
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    startActivity(i);
} else {
    text.setText(descriptions[position]);
    dialog.show();
}