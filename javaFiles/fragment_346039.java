@Override
public Integer getItem(int position) {
    if(mFileList == null)
       return 0;
    else
       return mFileList.size();

}