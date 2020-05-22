try {
                java.io.InputStream iss = getClass().getResourceAsStream("/nullpdf.pdf"); //update the filename here when the help guide is written
               // byte[] data = new byte[iss.available()];
                byte[] data = IOUtils.toByteArray(iss);
                iss.read(data);
                iss.close();
                String tempFile = "file";
                File temp = File.createTempFile(tempFile, ".pdf");
                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(data);
                fos.flush();
                fos.close();
            tmphelpfile = temp.getAbsolutePath();
            System.out.println(tmphelpfile);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("TEMP FILE NOT CREATED - ERROR in tmp file writing");
            }