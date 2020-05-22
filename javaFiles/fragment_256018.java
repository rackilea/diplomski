try {
            final ZipFile zipFile = new ZipFile("input.zip");
            File output = new File("out.zip");
            byte[] read = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(output));
            ZipEntry ze;
            zos.setLevel(ZipOutputStream.STORED);
            zos.setMethod(ZipOutputStream.STORED);
            while((ze = zis.getNextEntry()) != null) {
                int l;
                zos.putNextEntry(ze);
                System.out.println("WRITING:  " + ze.getName());
                while((l = zis.read(read)) > 0) {
                    zos.write(read, 0, l);
                }
                zos.closeEntry();
            }
            zis.close();
            zos.close();
            return "Done";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }