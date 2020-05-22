File apkReceived = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/"+receivedApkName + ".apk");

                if(apkReceived.exists()){

                    int new_int_postfix;

                    //Below _MAX is max numbers of file eg. _MAX = 100 
                    for(int i = 1; i < _MAX; i++) {

                    apkReceived = = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/"+receivedApkName +"("+ i +")"+".apk");
                        if(!apkReceived.exists()) {
                            String []name_without_pre = receivedApkName.split("\\(");
                            receivedApkName = name_without_pre[0];
                            new_int_postfix = i;
                            break;

                        }
                    }

                 apkReceived = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/"+receivedApkName + "("+new_int_postfix+")"+".apk");
                }

                byte[] buffer = new byte [8192];

                FileOutputStream fos=new FileOutputStream(apkReceived);