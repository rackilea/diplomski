...
   InputStream is = PapelServiceTest.class.getResourceAsStream("MY_FILE_HERE");
   byte[] pkBytes = IOUtils.toByteArray(is);

   String query = "INSERT INTO my_table (my_key_col) VALUES (?)";
   PreparedStatement pstat = conn.prepareStatement(query);
   pstat.setBytes(1, pkBytes);
   pstat.execute();
...