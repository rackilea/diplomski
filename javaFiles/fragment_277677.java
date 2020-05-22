final long ONE_MEGABYTE = 1024 * 1024; // or to the maximum size of your text, but careful it crashes if it's too big
httpsReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
    @Override
    public void onSuccess(byte[] bytes) {
        // String s = new String(bytes); should contain the text
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull Exception exception) {
        // Handle any errors
    }
});