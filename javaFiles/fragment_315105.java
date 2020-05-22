// Please don't use caps for non-constants
int serverResponseNumber = ServerInterface.sendRequest();
ServerResponse serverResponse = ServerResponse.fromInt(serverResponseNumber);

if (serverResponse == null) {
    // Do something with an unknown response - switch will barf otherwise.
    // Possibly throw an exception yourself?
}
switch(serverResponse) {
    case SIGN_UP_SUCCESS:
    ...
}