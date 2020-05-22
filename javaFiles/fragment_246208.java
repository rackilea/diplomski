public static View.OnClickListener getShareButtonClickListener(Activity activity) {
    return new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Drawable myDrawable = scannedImageView.getDrawable();
            Bitmap bitmap = ((BitmapDrawable)myDrawable).getBitmap();
            try{
                File file = new File(activity, "myImage.png");
                FileOutputStream fOut = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, fOut);
                fOut.flush();
                fOut.close();
                file.setReadable(true, false);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                intent.setType("image/png");
                activity.startActivity(Intent.createChooser(intent, "Share Image Via"));
            }catch (FileNotFoundException e){
                e.printStackTrace();
                Toast.makeText(activity, "File not found", Toast.LENGTH_SHORT).show();
            }catch (IOException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };
}