public File getBitmapFromwebchartView(WebView view2) {

File fi = null;

if (view2 != null) {
    view2.setDrawingCacheEnabled(true);
    Bitmap b = view2.getDrawingCache();
    if (b != null) {


        try {

            fi = new File(Environment.getExternalStorageDirectory(), "Screenshot" + ".jpg");
            //fi     = new File(Environment.getExternalStorageDirectory(),"Realitycheck" + ".jpg");

            // write the bytes in file
            FileOutputStream fo;

            fo = new FileOutputStream(fi);

            b.compress(CompressFormat.JPEG, 95, fo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
return fi;
}