if(getArguments().getExtras != null) {
    String catid = getArguments.getStringExtra("id");
    String catname = getArguments.getStringExtra("name");

    yourEditText.setText(catname);
}