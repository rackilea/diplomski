PreparedStatement ps = conn.prepareStatement("INSERT INTO image_table (id, content) VALUES (?, ?)");
ps.setInteger(1, 1);
ps.setBytes(2, content);
ps.executeUpdate();
ps.setInteger(1, 2);
ps.executeUpdate();
ps.close();