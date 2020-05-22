Uri uri = Uri.parse("URI_OF_YOUR_IMAGE");

    Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
    intent.addCategory(Intent.CATEGORY_DEFAULT);
    intent.setDataAndType(uri, "image/jpeg");
    intent.putExtra("mimeType", "image/jpeg");
    this.startActivity(Intent.createChooser(intent, "Set as:"));