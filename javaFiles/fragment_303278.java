ByteArrayInputStream finalBis = bis;
    byte[] finalFileUploadedBytes = fileUploadedBytes;
    DB.getConnection(connection -> {
        if (connection.succeeded()) {
            CallableStatement stmt = null;
            try {
                stmt = connection.result().getConnection().prepareCall(SQL.INSERT_DOCS_QUERY);
                stmt.setBinaryStream(1, finalBis, finalFileUploadedBytes.length);
                stmt.setString(2,desiDoc);
                stmt.setString(3,sourDoc);
                logger.debug(stmt);
                stmt.execute();
                finalBis.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("nooot  ok");
        }
    });