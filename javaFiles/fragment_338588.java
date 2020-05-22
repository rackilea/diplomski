// Create options
   QueryListenOptions options = new QueryListenOptions().includeDocumentMetadataChanges();

   // Pass them when you add the listener
   collectionReference.addSnapshotListener(options, new EventListener<QuerySnapshot>() {
       // ...
   });