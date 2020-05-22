listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        arrIdJob.remove(i);

        // Clear the other lists!
        arrJobTitle.remove(i);
        arrCompanyName.remove(i);
        arrState.remove(i);
        arrMinSal.remove(i);
        arrIdJobStr.remove(i);
        arrQualification.remove(i);
        arrIdCompany.remove(i);
        arrDesc.remove(i);

        adapterListHome.notifyDataSetChanged();
    }
});