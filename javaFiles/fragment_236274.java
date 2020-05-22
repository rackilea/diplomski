@POST
@Produces("application/json")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public void createCommunity(@FormParam("idToken") String idToken,
                                @Suspended final AsyncResponse response) {
    Authenticate(idToken, new AuthenticationListener() {
        @Override
        public void onAuthenticationSuccess() {
            DatabaseReference ref = FirebaseDatabase.getInstance()
                    .getReference("/mysamplenode");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String res = dataSnapshot.getKey();                        
                    response.resume(Response.status(200).entity().build());
                }
                @Override
                public void onCancelled(DatabaseError arg0) {
                    response.resume(Response.status(500).entity("DatabaseError").build());
                }
            });
        }
        @Override
        public void onAuthenticationFailure() {
            response.resume(Response.status(403).entity("Forbidden").build());
        }
    });
}