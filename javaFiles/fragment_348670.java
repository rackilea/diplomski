@Override
    protected void onPostExecute( DeserializedContainer result) {

        mListener.onSuccess( result );

        for (int i = 0; i <result.deserializedContainerList.size(); i++) {
            DeserializedVariables deserializedVariables = result.deserializedContainerList.get(i);
            Log.d( TAG, "onPostExecuss: " + deserializedVariables.getMovieName() );
        }

    }