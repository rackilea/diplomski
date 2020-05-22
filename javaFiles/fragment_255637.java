// check if session corresponds to the roomnumber 
  for (Map.Entry<String, Session> entry : openSessions.entrySet()) {

    Session s = entry.getValue();
    if (s.isOpen() && s.getUserProperties().get("roomnumber").equals(roomnumber_you_want_to_address)) {
  ...