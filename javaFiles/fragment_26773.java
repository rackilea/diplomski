SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
String fileName = dateFormat.format(new Date()) + ".jpg";

// or use timestamp e.g String fileName = System.currentTimeMillis()+".jpg";

File photo = new File(Environment.getExternalStorageDirectory(), fileName);

Intent cameraintent = new Intent("android.media.action.IMAGE_CAPTURE");
cameraintent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
startActivityForResult(cameraintent, 1);