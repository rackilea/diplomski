private void displayDetail(Diseases diseases) {

    Intent intent = new Intent(getActivity(), DetailActivity.class);
    intent.putExtra(DISEASES_TITLE, diseases.getTitle());
    intent.putExtra(DISEASES_DESC, diseases.getDescription());
    startActivityForResult(intent, DETAIL_REQUEST_CODE);
}