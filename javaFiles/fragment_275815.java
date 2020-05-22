public static class MyAsyncTask extends AsyncTask<Event, Integer, Double> {
    public interface OnRoutineFinished{  //interface
        void onFinish();
    }
    private OnRoutineFinished mCallbacks;
    public MyAsyncTask(OnRoutineFinished callback){ //constructor with interface
        mCallbacks = callback;
    }

    public MyAsyncTask(){} //empty constructor to maintain compatibility

    @Override
    protected Double doInBackground(Event... params) {
        try {
            eventAddress = eventCtrl.getStreetAddressFromGeometry(eventModel.getEventX(), eventModel.getEventY());
            eventCtrl.retrieveEventJSON();
            if (params.length == 1) {
                eventCtrl.createEvent(params[0]);
                // Refresh map after successfully added event
                eventCtrl.retrieveEventJSON();
                eventCtrl.plotEventOnMap(context);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Double result) {
        if(mCallbacks !=null)
            mCallbacks.onFinish(); //call interface on finish
    }

    protected void onProgressUpdate(Integer... progress) {
    }
}