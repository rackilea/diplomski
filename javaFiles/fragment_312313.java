Command comando = new Command(0, "mount -o remount,rw -t yaffs2 /dev/block/mtdblock3 /system";
    try {
        RootTools.getShell(true).add(comando);
    } catch (IOException | RootDeniedException | TimeoutException ex) {
        ex.printStackTrace();
    }