final CountDownLatch sync = new CountDownLatch(1);
ref.push().setValue("new value")
   .addOnCompleteListener(new DatabaseReference. CompletionListener() {
     @Override
     public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
       if (databaseError != null) {
         System.out.println("Data could not be saved " + databaseError.getMessage());
       } else {
         System.out.println("Data saved successfully.");
       }
       sync.countDown();
     }
});
sync.await();