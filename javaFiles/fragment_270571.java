public void onLoadFinished(Loader<User> arg0, User userInstance) {
    Log.i("status", "" + userInstance);
    if (userInstance == null) {
        Toast.makeText(getApplicationContext(),"User Id and Password is wrong", Toast.LENGTH_SHORT).show();
    } else {
        getLoaderManager().destroyLoader(arg0.getId());
        Intent intent = new Intent(LoginActivityService.this,
            ProposalListActivity.class);
        startActivity(intent);
    }
}