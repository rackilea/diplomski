@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)     {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK && requestCode == pick) {


        try {

            File newfile;

            AssetFileDescriptor videoAsset = getContentResolver().openAssetFileDescriptor(data.getData(), "r");
            FileInputStream in = videoAsset.createInputStream();

            File filepath = Environment.getExternalStorageDirectory();
            File dir = new File(filepath.getAbsolutePath() + "/" +"Your Folder Name" + "/");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            newfile = new File(dir, "save_"+System.currentTimeMillis()+".mp4");

            if (newfile.exists()) newfile.delete();



            OutputStream out = new FileOutputStream(newfile);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

            Log.v("", "Copy file successful.");


            videoUri = data.getData();
            videoview.setVideoURI(videoUri);
            videoview.start();



        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}