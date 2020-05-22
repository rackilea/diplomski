public void copyFile(String src, String target) {
        final String fileName = getFileName(src);
        try (FileChannel from = (FileChannel.open(Paths.get(src), StandardOpenOption.READ));
                FileChannel to = (FileChannel.open(Paths.get(target + "/" + fileName), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE))) {
            transfer(from, to, 0l, from.size());
        }
    }

    private String getFileName(final String src) {
        File file = new File(src);
        if (file.isFile()) {
            return file.getName();
        } else {
            throw new RuntimeException("src is not a valid file");
        }
    }

    private void transfer(final FileChannel from, final FileChannel to, long position, long size) throws IOException {
        while (position < size) {
            position += from.transferTo(position, Constants.TRANSFER_MAX_SIZE, to);
        }
    }