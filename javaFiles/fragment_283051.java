private void saveNote() {

    String title1="",title2="",title3="";
    for(int position = 0; position<mSectionsPagerAdapter.getCount();position++){
        Fragment fragment = mSectionsPagerAdapter.getItem(position);
        if(fragment instanceof Frag1){
            title1 = ((Frag1)fragment).getTitle();
        } else  if(fragment instanceof Frag2){
            title2 = ((Frag2)fragment).getTitle();
        } else  if(fragment instanceof Frag2){
            title3 = ((Frag2)fragment).getTitle();
        }
    }

    boolean valid = !TextUtils.isEmpty(title1);
    valid = valid && !TextUtils.isEmpty(title2);
    valid = valid && !TextUtils.isEmpty(title3);

    Note note;

    if(!valid){
        Toast.makeText(this, "Please provide inputs", Toast.LENGTH_SHORT).show();
        return;
    }
    note = new Note((mLoadedNote != null)?mLoadedNote.getDateTime():System.currentTimeMillis(), title1, title2, title3);

    if (Utilities.saveNote(this, note)){
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    } else{
        Toast.makeText(this, "not enough space", Toast.LENGTH_SHORT).show();
    }

    finish();
}