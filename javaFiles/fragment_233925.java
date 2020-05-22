JSONArray mArray = new JSONArray(myString);
int id_count = 0;
int devices_count = 0;
int tmp = 0;

for (int i = 0; i<mArray.length(); i++) {
    try {
        tmp = mArray.getJSONObject(i).getInt("id");
        id_count = id_count + 1;
    }
    catch (JSONException e) {
        // If id doesn't exist, this exception is thrown
    }  
    try {
        tmp = mArray.getJSONObject(i).getInt("number_of_devices");
        devices_count = devices_count + 1;
    }
    catch (JSONException e) {
        // If number_of_devices doesn't exist, this exception is thrown
    }    
}

myTextView1.text = String.ValueOf(id_count);
myTextView2.text = String.ValueOf(devices_count);