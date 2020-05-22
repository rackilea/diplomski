public void run(String... args) throws Exception {
    fleetH2Repository.deleteAll();

    // Add fleet records
    String playerUuid1 = UUID.randomUUID().toString();
    String playerUuid2 = UUID.randomUUID().toString();
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 14), 3));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 15), 3));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 16), 3));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 17), 4));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 18), 4));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 19), 4));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 20), 3));
    fleetH2Repository.save(new ShipH2Record(playerUuid1, LocalDate.of(1364,3, 21), 4));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 14), 13));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 15), 13));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 16), 13));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 17), 12));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 18), 12));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 19), 11));
    fleetH2Repository.save(new ShipH2Record(playerUuid2, LocalDate.of(1364,3, 20), 11));

    // Create a dump and add a statement to drop everything to make the restore work.
    try {
        String backupFile = "h2.backup.zip";
        String tempOutputFilenName = "out.zip";
        Script.main("-url", "jdbc:h2:file:~/.OpenPatrician/h2.db;DB_CLOSE_ON_EXIT=FALSE",  "-user", "sa", "-script", tempOutputFilenName, "-options", "compression", "zip");
        File f = new File(tempOutputFilenName);
        ZipFile zipFile = new ZipFile(tempOutputFilenName);
        final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(backupFile));
        for(Enumeration e = zipFile.entries(); e.hasMoreElements(); ) {
            ZipEntry entryIn = (ZipEntry) e.nextElement();
            zos.putNextEntry(new ZipEntry(entryIn.getName()));

            InputStream is = zipFile.getInputStream(entryIn);
            byte[] firstBytes = "DROP ALL OBJECTS".getBytes();
            zos.write(firstBytes);
            byte[] buf = new byte[1024];
            int len;
            while ((len = (is.read(buf))) > 0) {
                zos.write(buf, 0, (len < buf.length) ? len : buf.length);
            }
            zos.closeEntry();
        }
        zos.close();
        f.delete();
    } catch (SQLException |IOException e) {
        e.printStackTrace();
    }
    // Restore
    try {
        RunScript.main("-url", "jdbc:h2:file:~/.OpenPatrician/h2.db;DB_CLOSE_ON_EXIT=FALSE",  "-user", "sa", "-script", "h2.backup.zip", "-options", "compression", "zip");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}