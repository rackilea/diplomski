Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(new onClickListener(){

    @Override
    public void onClick(){
        Preferences pref = MyActivity.this.getSharedPreferences()
        String s = pref.getString("sound","gsone");
}
});