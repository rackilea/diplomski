// try this
**DetailAct you send your dynamic data back to SherlockActivity like this way**
private Intent getDefaultShareIntent() {
        Intent intent = new Intent(this,SherlockActivity.class);

        intent.putExtra(Intent.EXTRA_TITLE, "judul_HERE");
        intent.putExtra(Intent.EXTRA_SUBJECT, "tanggal_HERE");
        intent.putExtra(Intent.EXTRA_TEXT, "link_HERE");
        setResult(RESULT_OK,intent);
        finish();
}

**SherlockActivity you get data from DetailAct like this way**
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==500){
            String judul = data.getStringExtra(Constants.TAG_Title);
            String img = data.getStringExtra(Constants.TAG_Img);
            String tanggal = data.getStringExtra(Constants.TAG_Created);
            String desk = data.getStringExtra(Constants.TAG_Post);
            String link = data.getStringExtra(Constants.TAG_Link);
        }
}