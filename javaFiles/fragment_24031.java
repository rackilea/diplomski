// Cancel Request
public void A() {
    String[] str = app.sharedData().getMap("users").get(user_id);
    synchronized(str){
        String currentrequeststate = str[0];
        if (RequestState.PENDING.equals(currentrequeststate) {
            str[0] = RequestState.CANCELLED;
            // cancel it and sending cancel message
        }else if (RequestState.ACCEPTED.equals(currentrequeststate)){
            // throw exception here (or take whatever action appropriate)
            // as this request was already accepted by the admin;
            // so it is too late for the user to cancel it
        }
    }
}


// Accept Request
public void B() {
    String[] str = app.sharedData().getMap("users").get(user_id);
    synchronized(str){
        String currentrequeststate = str[0];
        if (RequestState.CANCELLED.equals(currentrequeststate)) {
            // Already cancelled, admin cannot accept it now as it's too late;
            // so take whatever action is appropriate in this case
        } else {
            str[0] = RequestState.ACCEPTED;
            // OK, accept it and sending accept message
        }
    }
}