while (rs.next()) {
    Vector<Object> newRow = new Vector<Object>();

    for (int i = 1; i <= numberOfColumns; i++) {
        if (i == <imageColumn>) {  // ... whatever column is your image column
            Blob blob = rs.getBlob("image");
            int blobLength = (int) blob.length();  

            byte[] bytes = blob.getBytes(1, blobLength);
            blob.free();
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
            ImageIcon icon = new ImageIcon(img);  
            newRow.addElement(icon);  
        } else {
            newRow.addElement(rs.getObject(i));
        }
    }
    rows.addElement(newRow);
}