ArrayList<String> textMatchList = new ArrayList<String>();

protected void onActivityResult(int requestCode, int resultCode, Intent data) { 
    if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)
        if(resultCode == RESULT_OK) {
            textMatchList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
    ...
    ...
    mlvTextMatches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            EditText InputText = (EditText) findViewById(R.id.inptWord);
            InputText.setText(textMatchList.get(position));
        }
    });
}