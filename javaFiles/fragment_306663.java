public void archivingTheFile(String zipFile){
            byte[] buffer = new byte[1024];

            //wrap the resources inside try(....)
            try(FileOutputStream fos = 
                        new FileOutputStream(zipFile);
                    ZipOutputStream zos = new ZipOutputStream(fos);) {
                for(String file : this.fileList){
                    ZipEntry ze= new ZipEntry(file);
                    zos.putNextEntry(ze);

                    //wrap this resource as well inside try(....)
                    try(FileInputStream in = 
                      new FileInputStream(SOURCE_FOLDER + File.separator + file)){
                        int len;
                        while ((len = in.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }
                    } catch(IOException ex) {
                         LOGGER.error("Exception occurred while zipping file",ex);
                    }
                }
            }catch(IOException ex){
                LOGGER.error("Exception occurred while zipping file",ex);
            }
        }