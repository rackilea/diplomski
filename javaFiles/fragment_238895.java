if (Patterns.WEB_URL.matcher(result).matches()) {
    builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            Intent browserIntent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(!result.startsWith("http://") && !result.startsWith("https://") ? "http://" + result : result)
            );
            startActivity(browserIntent);
        }
    });
}