Process suProcess;
DataOutputStream os;


try{
        //Get Root
        suProcess = Runtime.getRuntime().exec("su");
        os= new DataOutputStream(suProcess.getOutputStream());

        //Remount writable FS within the root process
        os.writeBytes("mount -w -o remount -t ext4 /dev/block/mmcblk0p9 /system\n");
        os.flush();

        //Do something here
        os.writeBytes("rm /system/somefile\n");
        os.flush();

        //Do something there
        os.writeBytes("touch /system/somefile\n");
        os.flush();

        //Remount Read-Only
        os.writeBytes("mount -r -o remount -t ext4 /dev/block/mmcblk0p9 /system\n");
        os.flush();

        //End process
        os.writeBytes("exit\n");
        os.flush();

   }
catch (IOException e) {
        throw new RuntimeException(e);
    }