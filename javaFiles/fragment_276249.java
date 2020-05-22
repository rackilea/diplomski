class Downloader extends SwingWorker<Object, Object> {
   @Override
   public Object doInBackground() {
       return doDownload();
   }

   @Override
   protected void done() {
       try { 
         frame.downloadDone(get());
       } catch (Exception ignore) {
       }
   }
}

(new Downloader()).execute();