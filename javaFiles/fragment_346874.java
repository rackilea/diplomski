@Override
protected void onPostExecute(String result) {    
    progress.dismiss();
    Toast.makeText(getActivity().getApplicationContext(), result,
                Toast.LENGTH_LONG).show();

    handler.post(new Runnable() {
        @Override
        public void run() {
            hideKeybord(edt_txt);
            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            StoreProfileGridFragment fm2 = new StoreProfileGridFragment();
            fragmentTransaction.replace(R.id.relative_sendimage_send, fm2,
                "HELLO");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();            
        }
    });

    return;
}