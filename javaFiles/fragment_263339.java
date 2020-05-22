AdapterView.OnItemClickListener myOnItemClickListener = new AdapterView.OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int prompt = (int)parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), prompt, Toast.LENGTH_LONG).show();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", prompt);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

}};