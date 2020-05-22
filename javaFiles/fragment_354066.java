PreparedStatement pstat = 
    conn.prepareStatement("UPDATE tbl_blob SET file_content=? WHERE file_name=?");

pstat.setBlob(1, new ByteArrayInputStream(new String(content).getBytes("UTF-8")));
pstat.setString(2, myFileName);
pstat.executeUpdate();