View.OnClickListener myClickListener= new View.OnClickListener() {
    public void onClick(View v) {
        String tag = (String) v.getTag();
        sharedPref
             .edit()
             .putInt(tag, shardPref.getInteger(tag) + 1)
             .apply();
    }
};