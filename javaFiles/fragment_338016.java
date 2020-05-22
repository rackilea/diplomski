FileInputStream fis = new FileInputStream(imagePath);
        int b;
        byte[] bytes = IOUtils.toByteArray(fis);
        fis.close();

        // This will insert the picture from start cell to end cell of excel
        // sheet.
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,
                start.getCol(), start.getRow(), end.getCol(), end.getRow());

        anchor.setAnchorType(2);

        int index = wb.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG);

        // Create the drawing patriarch. This is the top level container for all shapes. 
        Drawing patriarch = sheet.createDrawingPatriarch();
        try {
            HSSFPicture picture = patriarch.createPicture(anchor, index);
            // picture.resize();
        } catch (Exception e) {
            String err = e.getMessage();
        }