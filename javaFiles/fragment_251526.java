// Copy file
            File tmpFile = File.createTempFile(...);
            tmpFile.deleteOnExit();
            try(OutputStream outputStream = new FileOutputStream(tmpFile);
                InputStream pdf = ClassB.class.getResourceAsStream("packageA/test.pdf"); ){

                byte[] buffer = new byte[1024];
                int length;
                while ((length = pdf.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }//autoClose
            //now tmpFile is the pdf
             Desktop.getDesktop().open(tmpFile);