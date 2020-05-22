public void ringtonemove(String ringtype){


         String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();
         String outpath = sdcard + "/ringtones";
         String path = sdcard + "/multi10/" + Global.currentboard + "/series10";

         if (ringtype == "MultiboardRing") {outpath = sdcard + "/ringtones/";}
         if (ringtype == "MultiboardNotif") {outpath = sdcard + "/notifications/";}
         if (ringtype == "MultiboardAlarm") {outpath = sdcard + "/alarms/";}

    File in = new File(path, Global.currentsound);
    File out = new File(outpath, ringtype + ".ogg");
    Global.k = outpath + ringtype + ".ogg";



         File folderR = new File(Environment.getExternalStorageDirectory() + "/ringtones");
         File folderN = new File(Environment.getExternalStorageDirectory() + "/notifications");
         File folderA = new File(Environment.getExternalStorageDirectory() + "/alarms");
         if (folderR.exists()); else {folderR.mkdir();}
         if (folderN.exists()); else {folderN.mkdir();}
         if (folderA.exists()); else {folderA.mkdir();}



                     Log.d("Notice", "Copying sound file " + in);
                     try {
                        FileInputStream fis = new FileInputStream(in);
                           int size = fis.available();
                             byte[] buffer = new byte[size];
                             fis.read(buffer);
                             fis.close();

                             FileOutputStream fos = new FileOutputStream(out);
                             fos.write(buffer);
                             fos.close();



                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


    }