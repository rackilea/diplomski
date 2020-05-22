byte[] bytes;
        try {

            File file = new File("/storage/extSdCard/Test.pdf");
            FileInputStream is = new FileInputStream(file);

            // Get the size of the file
            long length = file.length();
            bytes = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
                offset += numRead;
            }
            ByteBuffer buffer = ByteBuffer.NEW(bytes);
            String data = Base64.encodeToString(bytes, Base64.DEFAULT);
            PDFFile pdf_file = new PDFFile(buffer);
            PDFPage page = pdf_file.getPage(2, true);

            RectF rect = new RectF(0, 0, (int) page.getBBox().width(),
            (int) page.getBBox().height());

            Bitmap image = page.getImage((int)rect.width(), (int)rect.height(), rect);
            FileOutputStream os = new FileOutputStream("/storage/extSdCard/pdf.jpg");
            image.compress(Bitmap.CompressFormat.JPEG, 80, os);
            //((ImageView) findViewById(R.id.testView)).setImageBitmap(image);

        } catch (Exception e) {
            e.printStackTrace();
        }