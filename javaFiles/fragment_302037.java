public static void storeInDB() throws IOException, SQLException {

    double[] dubs = new double[300];

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    DataOutputStream dout = new DataOutputStream(bout);
    for (double d : dubs) {
        dout.writeDouble(d);
    }
    dout.close();
    byte[] asBytes = bout.toByteArray();

    PreparedStatement stmt = null;  // however we normally get this...
    stmt.setBytes(1, asBytes);

}

public static double[] readFromDB() throws IOException, SQLException {

    ResultSet rs = null;  // however we normally get this...
    while (rs.next()) {
        double[] dubs = new double[300];
        byte[] asBytes = rs.getBytes("myDoubles");
        ByteArrayInputStream bin = new ByteArrayInputStream(asBytes);
        DataInputStream din = new DataInputStream(bin);
        for (int i = 0; i < dubs.length; i++) {
            dubs[i] = din.readDouble();
        }
        return dubs;
    }

}