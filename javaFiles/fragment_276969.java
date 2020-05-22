DocumentReference senderRef = challengeRef
    .document(loggedUserEmail)
    .collection("challenges_feed")
    .document(callengeID);

Map<String, Object> updates = new HashMap<>();
updates.put("latestUpdateTimestamp", FieldValue.serverTimestamp());
updates.put("challangeId", "newChallangeId");
senderRef.update(updates).addOnCompleteListener(new OnCompleteListener<Void>() {/* ... */}