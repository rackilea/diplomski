private static void fg_downloadFile(final FragMyDrive frag, final File file, final Drive drive){
    final String key = frag.getCastedActivity().getKey();
    final Context context = frag.getCastedActivity().mService;

    Runnable rx_downloadFile = new Runnable() {
        @Override
        public void run() {
            bg_downloadFile(context, key, file, drive);
        }
    }; 
    //.... Submit runnable to service...
}