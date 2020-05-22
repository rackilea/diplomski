JSONObject jsonObj = new JSONObject(YOUR_JSON_STRING);

// Participants
JSONArray participantsJsonArray = jsonObj.getJSONArray("Participants");

// Participant
JSONObject participanJsonObject = participantsJsonArray.getJSONObject(0);

// PlayerName
String playerName = participanJsonObject.getString("PlayerName");
// ID
String id = participanJsonObject.getInt("ID");