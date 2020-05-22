public String getErrorLog(){
    String returnString = "";
            try {
                Connection conn = AzkabanClient.getPhoenixConnection(conf);
                String s = " select exec_id, enc_type,  log from execution_logs where exec_id = 3964 and name = 'http-time-series-hourly' ";
                PreparedStatement pstmt = conn.prepareStatement(s);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int i = rs.getInt("exec_id");
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    EncodingType encType = EncodingType.fromInteger(rs.getInt("enc_type"));
                    int debug = 0;
                    byte[] data = rs.getBytes("log");
                    try {
                        byte[] buffer = data;
                        ByteArrayOutputStream byteArrayOutputStream = null;
                        if (encType == EncodingType.GZIP) {
                            byteArrayOutputStream = GZIPUtils.unGzipBytesOutputStream(data);
                        }

                        returnString = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (IOException e) {
                        throw new SQLException(e);
                    }
                }
                conn.close();
            } catch (Exception e) {
                LOGGER.error("Error =>" + e);
            }

            return returnString;
}