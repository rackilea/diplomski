try {
    JSONObject responseObject = new JSONObject(response);
    if (responseObject != null) {
        /* Try create a new JSON object from the 
         * responseData object. If it fails, 
         * display an alert */
        try {
            JSONObject responseData = responseObject
                    .getJSONObject("responseData");

            if (responseData != null) {
                String translatedText = responseData
                        .getString("translatedText");
                Notify.alert(translatedText);
            } 

        } catch (Exception e) {
            String responseDetails = responseObject
                    .getString("responseDetails");
            Notify.alert(responseDetails);
        }
    }
} catch (Exception e) {
    Notify.alert("Unable to translate outer block!");
}