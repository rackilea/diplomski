//First class:
        final File file = new File(initFilePath);
        new Thread(new Runnable() {
        @Override
        public void run() {
            FileFoldersLab.get(getContext()).copyFile(file,FileFoldersLab.get(getContext()).getCurPath());

            updateUI();
        }
        }).start();

        //FileFoldersLab:
        public void copyFile(final File src, final String destPath){
        final File f = new File(destPath+File.separator+src.getName());
        if(f.exists()){
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("The file already exists");
                builder.setMessage("Would you like to rewrite " + f.getPath()+ " ?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Copying file

     //After copying 
FileFoldersLab.get(getContext()).removeFile(file);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            //Showing the alert dialog
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            }else{
                //Copying file
    //After copying
    FileFoldersLab.get(getContext()).removeFile(file);
            }
        }