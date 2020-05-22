public CustomRequest getCustomRequest(Member member, 
    Address address,Member member){
    CustomRequest customRequest = new CustomRequest();
    CompletableFuture.runAsync(() -> {
        populateAddress(address, customRequest);
        populatecontact(contact, customRequest);
        populateMemberDetails(member, customRequest);
    }).get();//EDIT: added get method here to wait for the execution
    return customRequest;
}