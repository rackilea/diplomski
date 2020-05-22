spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> parent, View view,
            int pos, long id) {
        Message mSelected = mSelected.setSpinnerPosition(pos);
        Log.i("Id:", mSelected.getId());

    }
}