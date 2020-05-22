File homeFolder = new File(System.getProperty("user.home"));
File testAppDir = new File(homeFolder, ".testAPP");
File databaseDir = new File(testAppDir, "database");
File dataFile = new File(databaseDir, "data.xml");
if (!databaseDir.isDirectory())
    if (!databaseDir.mkdirs())
        throw new IOException("Failed to create directory");
dataFile.createNewFile();