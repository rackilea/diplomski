jqMobileChk.setOnClickListener(new OnClickListener() {  
    @Override
    public void onClick(View v) {

        if(jqMobileChk.isChecked()) {
            libraryMap.put(0, "<script src=\"http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js\"></script>\n");

        } else if(!jqMobileChk.isChecked()) {
            libraryMap.remove(0);
        }
    }
});