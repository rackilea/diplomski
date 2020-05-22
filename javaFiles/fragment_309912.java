submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mDatabase = database.getReference("diary");
        String fdiary =diary.getText().toString();
        String ftitle =titlee.getText().toString();

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Diary", fdiary);
        hashMap.put("Title", ftitle);

        mDatabase.push().setValue(hashMap);
    }
});