ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document(PageSize.A4, 10, 10, 10, 10);
            PdfWriter.getInstance(document, baos);
            document.open();
            Image image = Image.getInstance(decodedBytes);
            image.scalePercent(50);
            document.add(image);
            document.close();

            DataSource pdfds = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
            pdfBodyPart.setDataHandler(new DataHandler(pdfds));
            //pngBodyPart.setHeader("Content-ID", "<dashboard>");
            //pngBodyPart.setDisposition(MimeBodyPart.INLINE);
            pdfBodyPart.setFileName("AnnotatedDashboard.pdf");
            multipart.addBodyPart(pdfBodyPart);
            // Send the complete message parts
            message.setContent(multipart);