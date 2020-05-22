pw.println("[");
while (j.next()) {
    state_id = j.getString(1);
    state = j.getString(2);
    country_ref = j.getString(3);
    pw.println("{stateId: " + state_id + ", stateName: \"" + state +"\"},");
}
pw.println("]");