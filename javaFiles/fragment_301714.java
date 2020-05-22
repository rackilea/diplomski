public void upload() throws SQLException {
    if (file != null) {
        try (InputStream inputStream = file.getInputStream()) {

            long lastTimestamp = System.currentTimeMillis();
            int pushInterval = 1000;
            long totalRead = 0;
            long size = file.getSize();

            Connection conn = ds.getConnection();
            // insert into database file
            boolean committed = false;
            try {
                conn.setAutoCommit(false);

                try (PreparedStatement ps =
                        conn.prepareStatement("INSERT INTO PROCEDURE_FILES"
                                + " (ID, PROCEDURE_ID, FILE_NAME, FILE) "
                                + " VALUES (?, ?, ?, ?)")) {
                    ps.setInt(1, obj.number);
                    ps.setInt(2, obj.number);
                    ps.setString(3, "tests");
                    ps.setBinaryStream(4, inputStream);

                    ps.executeUpdate();
                }

                conn.commit();
                committed = true;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                if (!committed) {
                    conn.rollback();
                }
                conn.close();
            }

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Upload successfully ended!"));
        }
        catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Upload failed!"));
        }
    }
}