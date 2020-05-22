protected void populateVisitedLinks() {
     ValueCallback callback = new ValueCallback<String[]>() {
         public void onReceiveValue(String[] value) {
             sendMessage(EventHub.POPULATE_VISITED_LINKS, (Object)value);
         }
     };
     mCallbackProxy.getVisitedHistory(callback);
 }