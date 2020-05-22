.map(service -> {
     try {
         return service.deleteLockStatus();
     }
     catch(Exception e) {
         e.printStackTrace();
         return null;
     }
 })