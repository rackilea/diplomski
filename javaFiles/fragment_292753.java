try (
        PreparedStatement thisPs = conn.prepareStatement("INSERT INTO thisTable (thisId, thisText) VALUES (?,?)");
        PreparedStatement thatPs = conn.prepareStatement("INSERT INTO thatTable (thatId, thatText) VALUES (?,?)")) {

    thisPs.setInt(1, 1);
    thisPs.setString(2, "thisText1");
    thisPs.addBatch();

    thatPs.setInt(1, 1);
    thatPs.setString(2, "thatText1");
    thatPs.addBatch();

    thisPs.setInt(1, 2);
    thisPs.setString(2, "thisText2");
    thisPs.addBatch();

    thatPs.setInt(1, 2);
    thatPs.setString(2, "thatText2");
    thatPs.addBatch();

    thisPs.executeBatch();
    thatPs.executeBatch();
}