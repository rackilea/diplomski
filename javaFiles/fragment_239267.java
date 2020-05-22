public void appendFileInTarArchive(String tarPath, String tarFileName, String file2WriteName, String file2WriteContent) throws AuthenticationException, IOException {
    if (tarPath == null || tarFileName == null || tarFileName.isEmpty()) {
        LOG.warn("The path or the name of the tar archive is null or empty.");
        return;
    }
    final File tarFile = new File(tarPath, tarFileName);
    final File fileToAdd = new File(tarPath, file2WriteName);
    FileUtils.write(fileToAdd, file2WriteContent);

    if (file2WriteName == null || file2WriteName.isEmpty()) {
        LOG.warn("The name of the file to append in the archive is null or empty.");
        return;
    }

    ArchiveStreamFactory asf = new ArchiveStreamFactory();

    File tempFile = new File(tarPath, "tmpTar.tar");
    tempFile.createNewFile();

    try {
        FileInputStream fis = new FileInputStream(tarFile);
        ArchiveInputStream ais = asf.createArchiveInputStream(ArchiveStreamFactory.TAR, fis);

        FileOutputStream fos = new FileOutputStream(tempFile);
        ArchiveOutputStream aos = asf.createArchiveOutputStream(ArchiveStreamFactory.TAR, fos);

        // copy the existing entries    
        ArchiveEntry nextEntry;
        while ((nextEntry = ais.getNextEntry()) != null) {
            aos.putArchiveEntry(nextEntry);
            IOUtils.copy(ais, aos);
            aos.closeArchiveEntry();
        }

        // create the new entry
        TarArchiveEntry entry = new TarArchiveEntry(file2WriteName);
        entry.setSize(fileToAdd.length());
        aos.putArchiveEntry(entry);
        IOUtils.copy(new FileInputStream(fileToAdd), aos);
        aos.closeArchiveEntry();

        aos.finish();

        ais.close();
        aos.close();

        // copies the new file over the old
        tarFile.delete();
        tempFile.renameTo(tarFile);

    } catch (ArchiveException e) {
        LOG.error(e.getMessage(), e);
    } catch (IOException e) {
        LOG.error(e.getMessage(), e);
    } finally {
        FileUtils.deleteQuietly(fileToAdd);
    }
}