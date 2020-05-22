FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
Query firstQuery = rootRef...
Query secondQuery = rootRef...

Task firstTask = firstQuery.get();
Task secondTask = secondQuery.get();

Task combinedTask = Tasks.whenAllSuccess(firstTask, secondTask).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
    @Override
    public void onSuccess(List<Object> list) {
         //Do what you need to do with your list
    }
});