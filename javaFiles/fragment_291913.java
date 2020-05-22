String text=mService.getString();
if (Protocols.REQUEST_SEND_MESSAGE.equals(text)) {
    publishProgress("sent");
} else if (Protocols.RESPONSE_OK.equals(text)) {
    mService.sendMessage("mesasage");
    publishProgress("sent"); 
}