@Override
    protected void onPostExecute(String result)
    {
        progressDialog.dismiss();
        FragmentTransaction ft= context.getFragmentManager().beginTransaction();
        ft.replace(R.id.content,new Fragment2());
        ft.commit();
    }