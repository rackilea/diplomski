@Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        currentTraining = (Training)arg0.getAdapter().getItem(arg2);
        Log.i ("DEBUG" , currentTraining.getTitle());

        CurrentTraining.getInstance().setTraining(currentTraining);

        Toast.makeText(getApplicationContext(), "You clicked on position : " + arg2 + " and ID : " + currentTraining.getId(), Toast.LENGTH_LONG).show();
        }