shareBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            Uri screenshotUri = FileProvider.getUriForFile(context, context.getPackageName() + ".MyFileProvider", new File(directoryToStore, filename))
            //the Uri above  - file:///storage/emulated/0/Android/data/myPackageName/files/SavedImages/test.jpeg
            sharingIntent.setType("image/jpeg");
            sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
            sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Intent chooserIntent = Intent.createChooser(sharingIntent, "Share image using");
            chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(chooserIntent);
        }
    });