String key = rs.getString("SessionID");
List<SessionRecord> myList = map.get(key);
if(myList == null) {
    myList = new ArrayList<>();
    myList.add(new SessionRecord(rs.getString("SessionID"),rs.getString("NetworkAddress"),rs.getString("EventType"),rs.getString("Time"),rs.getString("Name"),rs.getString("SessionType"),rs.getString("ProcessType")));
    map.put(key,myList);
} else {
    myList.add(new SessionRecord(rs.getString("SessionID"),rs.getString("NetworkAddress"),rs.getString("EventType"),rs.getString("Time"),rs.getString("Name"),rs.getString("SessionType"),rs.getString("ProcessType")));
}