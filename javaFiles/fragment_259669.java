try(ZipArchiveInputStream zipArchiveInputStream = new ZipArchiveInputStream(fileInputStream)) {
    ZipArchiveEntry zipEntry;

    while ((zipEntry = zipArchiveInputStream.getNextZipEntry()) != null){
        String fileName = zipEntry.getName();

        final File file = new File(fileName);

        FileUtil.createMissingParentDirectories(file);

        try(FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath())) {(file.read.buffer)
            try(BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream, 1024)) {
                int n = 0;

                byte[] content = new byte[1024];

                while ((n = zipArchiveInputStream.read(content)) != -1) {
                    fileOutputStream.write(content, 0, n);
                }

                bos.flush();
                }
            }
        }
    }
}