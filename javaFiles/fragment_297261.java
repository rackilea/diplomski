final String title_val = "KS1: " + mPostTitle.getText().toString().trim();
mDatabase2 = FirebaseDatabase.getInstance().getReference().child("Forums");
mDatabase2.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    void onDataChange(DataSnapshot forumsSnapshot) {
        boolean isTitleAlreadyUsed = false;

        for (DataSnapshot specificForum : forumsSnapshot.getChildren()) { 
            // Check if key 'title' exists and if title value is equal to value to save (title_val)  
            if (specificForum.hasChild("title") && (title_val.equals(specificForum.child("title").getValue()))){
                isTitleAlreadyUsed = true;
            }
        }

        if (isTitleAlreadyUsed) {
            String success = "Your title already exists...";
            Toast.makeText(PostActivityKinderSection1.this, success, Toast.LENGTH_LONG).show();
            mSubmitBtn.setEnabled(true);
        }
        else {
           mSubmitBtn.setEnabled(false);
           startPosting();
        }
    }
}