public CompletableFuture<CustomRequest> getCustomRequest(Member member, Address address, Member member){
    return CompletableFuture.supplyAsync(() -> {
        CustomRequest customRequest = new CustomRequest();
        populateAddress(address, customRequest);
        populatecontact(contact, customRequest);
        populateMemberDetails(member, customRequest);
        return customRequest;
    });
}