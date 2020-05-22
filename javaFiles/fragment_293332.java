try{
                File root = new File(Environment.getExternalStorageDirectory() +"/AppFolder");

                int i = 0;
                File sdImageMainDirectory = new File(root , "pic.png");
                while(sdImageMainDirectory.exists()){
                     i++
                     sdImageMainDirectory = new File(root , "pic" +i+ ".png");
                }
                outputFileUri = Uri.fromFile(sdImageMainDirectory);
                startCameraActivity();

             } catch (Exception e) {