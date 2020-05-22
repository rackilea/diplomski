Task firstTask = firstQuery.get();
Task secondTask = secondQuery.get();

Task combinedTask = Tasks.whenAllSuccess(firstTask, secondTask).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
        @Override
        public void onSuccess(List<Object> list) {
            //This is the list that I wanted
        }
});