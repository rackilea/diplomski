for (int i = 0; i < data_array.length (); i++) {
    try {
        String element = data_array.getString ( i );
        // Do whatever you want with element
    } catch (JSONException e) {
        e.printStackTrace ();  //To change body of catch statement use File | Settings | File Templates.
        Log.e ( "json_obj", String.valueOf ( e ) );
    }
}