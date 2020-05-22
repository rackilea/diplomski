public long copyDirectory(File source, File target, long sizeOfCopiedFiles,
        long sizeOfDirectory, ProgressDialog pd) {

    if (source.isDirectory()) {
        for (int i = 0; i < children.length; i++) {
            sizeOfCopiedFiles = copyDirectory(sourceChild, destChild,
                    sizeOfCopiedFiles, sizeOfDirectory, pd);
        }
    } else {
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
            sizeOfCopiedFiles += len;
            pd.setProgress((float)sizeOfCopiedFiles / sizeOfDirectory);
        }

    }
    return sizeOfCopiedFiles;
}