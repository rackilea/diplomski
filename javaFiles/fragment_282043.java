public void clearApplicationData(Context mContext) {
    File cache = mContext.getCacheDir();
    File appDir = new File(cache.getParent());
    if(appDir.exists()){
        String[] children = appDir.list();
        for(String s : children){
            if(!s.equals("lib")){
                deleteDir(new File(appDir, s));
                Log.i("TAG", "**************** File /data/data/APP_PACKAGE/" + s +" DELETED *******************");
            }
        }
    }
}