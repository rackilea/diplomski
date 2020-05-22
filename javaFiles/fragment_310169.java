public class DataDownloadEvent {
      ArrayList<DataDownloadListener> listeners = new ArrayList<DataDownloadListener>();
      public void setOnDownload(DataDownloadListener listener){
           this.listeners.add(listener);
      }
 }