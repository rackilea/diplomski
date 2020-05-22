@Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        boolean connected = dataSnapshot.getValue(Boolean.class);
        if (connected){
            Log.d("CONNECT","YES");
        }
        else {
            Log.d("CONNECT","NO");

        }

        GenericTypeIndicator<ArrayList<Integer>> genericTypeIndicator = new GenericTypeIndicator<ArrayList<Integer>>() {};
        array = dataSnapshot.getValue(genericTypeIndicator);

        handleArrayFunction(array);
    }