this.zos.putNextEntry(new ZipEntry(currentEntry));
        int len;
        while ((len = zis.read(buf)) >= 0)
        {
           zos.write(buf, 0, len);
        }