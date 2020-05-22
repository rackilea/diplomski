@POST
@Produces("application/json")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public void createCommunity(@FormParam("idToken") String idToken) {
    Response response;
    CountDownLatch latch = new CountDownLatch(1);
    Authenticate(idToken, new AuthenticationListener() {
        @Override
        public void onAuthenticationSuccess() {
            DatabaseReference ref = FirebaseDatabase.getInstance()
                    .getReference("/mysamplenode");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String res = dataSnapshot.getKey();                        
                    response = Response.status(200).entity().build();
                    latch.countDown();
                }
                @Override
                public void onCancelled(DatabaseError arg0) {
                    response = Response.status(500).entity("DatabaseError").build();
                    latch.countDown();
                }
            });
        }
        @Override
        public void onAuthenticationFailure() {
            response = Response.status(403).entity("Forbidden").build();
            latch.countDown();
        }
    });
    latch.await();
    return response;
}