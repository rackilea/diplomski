FirestoreUtil.getImportModules(ID, getApplicationContext(), new Function<Unit>() {
    @Override
    public Unit invoke() {
        Intent intent = new Intent(AddModActivity.this, EditImportUserActivity.class)
        intent.putExtra("moduleID", ID)
        intent.putExtra("moduleCode", code)
        intent.putExtra("moduleName", name)
        startActivity(intent)
        progressDialog.dismiss()
        return Unit.INSTANCE; //notice this line; Kotlin treats the Unit class as void, but Java treats it as an actual class
});