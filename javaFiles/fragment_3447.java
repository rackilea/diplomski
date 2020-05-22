public byte[] fetchPhoto(Long id) throws SQLException {
        Connection conn = DataSourceUtils.getConnection(dataSource);
        byte[] photo = null;
        Blob imageBlob = null;
        try (ResultSet rs = conn.createStatement()
                .executeQuery("select IMAGE from IMAGE_TABLE where IMAGE_ID = " + id)) {

            while (rs.next()) {
                imageBlob = rs.getBlob(1);
                photo = imageBlob.getBytes(1, (int) imageBlob.length());
                ByteArrayInputStream bais = new ByteArrayInputStream(photo);
                BufferedImage bf = ImageIO.read(bais);
                BufferedImage nbf = new BufferedImage(bf.getWidth(),
                        bf.getHeight(), BufferedImage.TYPE_INT_RGB);
                nbf.createGraphics().drawImage(bf, 0, 0, Color.WHITE, null);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(nbf, "jpg", baos);
                photo = baos.toByteArray();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            DataSourceUtils.releaseConnection(conn, dataSource);
        }
        return photo;
    }