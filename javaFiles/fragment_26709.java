class modifyCar extends AsyncTask<Void, Integer, ArrayList<Evento>> {
    private Car newCar;

    // a constructor so that you can pass the object and use
    modifyCar(Car newCar){
        this.newCar = newCar;
    }

    protected void onPreExecute()
    {
    }

    protected ArrayList<Evento> doInBackground(Void... parms) 
    {
        //The rest of the code using newCarAsync
    }

    protected void onProgressUpdate()
    {
    }

    protected void onPostExecute()
    {
    }
}