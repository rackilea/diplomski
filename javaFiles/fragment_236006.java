String packageName = getPackageName(); 
int resID = getResources().getIdentifier( "filename" , "raw" , packageName );
AssetFileDescriptor afd = getResources().openRawResourceFd(resId);
mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
mp.prepare();
mp.start();
afd.close();