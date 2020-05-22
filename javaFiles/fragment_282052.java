AppController.getInstance().addToRequestQueue(strReq); // Dispatch async call

if(SessionHandler.logged){ // This happens in the current UI thread (which be returning the default value or an exception
    return true;
} else {
    return false;
}