CustomXWPFDocument document = new CustomXWPFDocument(new FileInputStream(new File("C:\\Users\\Avarice\\Desktop\\doc1.docx")));
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Avarice\\Desktop\\doc2.docx"));
        String id = document.addPictureData(new FileInputStream(new File("C:\\Users\\Avarice\\Desktop\\thumbnail.jpg")), Document.PICTURE_TYPE_JPEG);
        document.createPicture(id,document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 64, 64);
        document.write(fos);
        fos.flush();
        fos.close();