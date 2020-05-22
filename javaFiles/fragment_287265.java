ResultSet rst = MyDB.rsFetch("SELECT `Picture` FROM `photo` WHERE `Employee ID` = '"+ Data.User.getText()+"'");
         while (rst.next()) {
         Blob filenameBlob = rst.getBlob("Picture");
         byte[] content = filenameBlob.getBytes(1L,(int)filenameBlob.length());
         ImageIcon ik = new ImageIcon(content);
         Image img = ik.getImage();
         Image newimg = img.getScaledInstance(Data.picture.getWidth(), Data.picture.getHeight(), java.awt.Image.SCALE_SMOOTH);
         ik = new ImageIcon(newimg);
         Data.picture.setIcon(ik);
         }