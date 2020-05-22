class HttpPostTask extends AsyncTask<Void, Void, ResponseStatus> {

    @Override
    protected ResponseStatus doInBackground( Void... params ){

        try {
            // do your HTTP stuff
            return ResponseStatus.SUCCESS;
        } catch( Exception e ){
            return ResponseStatus.FAILURE;
        }

    }

    @Override
    protected void onPostExecute( ResponseStatus status ){
        switch( status ){
        case SUCCESS:
            // run your success callback
            break;
        case FAILURE:
            // run the failure callback
            break;
        }
    }

}

enum ResponseStatus {
    SUCCESS,
    FAILURE
}