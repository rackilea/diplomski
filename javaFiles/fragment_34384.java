int checkExistence = mContext.getResources().getIdentifier("FILENAME_WITHOUT_EXTENSION", "raw", mContext.getPackageName());

if ( checkExistence != 0 ) {  // the resouce exists...
result = true;
}
else {  // checkExistence == 0  // the resouce does NOT exist!!
result = false;
}