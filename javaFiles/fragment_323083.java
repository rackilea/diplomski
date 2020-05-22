CallableStatement cstmt = conn.prepareCall("{? = CALL total_cancellations()}");
cstmt.registerOutParameter(1, Types.INTEGER);
cstmt.setInt(2, acctNo);
cstmt.executeUpdate();
int cancel= cstmt.getInt(1);
System.out.print("Cancellation is "+cancel);