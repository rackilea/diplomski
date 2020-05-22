final List<String> tokenContainer = new ArrayList<>();   
FirebaseAuth.getInstance().createCustomToken(person.getUid()).addOnSuccessListener(new OnSuccessListener<String>() {
    @Override
    public void onSuccess(String customToken) {
        tokenContainer.add(customToken);
    }
});
return tokenContainer.get(0);