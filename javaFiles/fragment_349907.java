while (ze != null) {

            String fileName = ze.getName();
            File newFile = new File(outputFolder + File.separator
                    + fileName);

            if (ze.isDirectory()) {
                File directory = new File(newFile.getPath());
                directory.mkdirs();
                ze = zis.getNextEntry();
                continue;
            }

            System.out.println("file unzip : " + newFile.getAbsoluteFile());

            FileOutputStream fos = new FileOutputStream(newFile);

            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            fos.close();
            ze = zis.getNextEntry();
        }