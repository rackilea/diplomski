File file = new File("myimage.gif");
FileInputStream fis = new FileInputStream(file);
PreparedStatement ps = conn.prepareStatement(
    "INSERT INTO images VALUES (?, ?)"
);
ps.setString(1, file.getName());
ps.setBinaryStream(2, fis, (int)file.length());
ps.executeUpdate();
ps.close();
fis.close();