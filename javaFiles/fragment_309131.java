private File initUsersText() throws Exception
{
    Path dir = testdir.getPath().toRealPath();
    FS.ensureDirExists(dir.toFile());
    File users = dir.resolve("users.txt").toFile();

    writeUser( users );
    return users;
}


private File initUsersText() throws Exception
{
    Path dir = testdir.getPath().toRealPath();
    FS.ensureDirExists(dir.toFile());
    File users = dir.resolve("users.txt").toFile();

    writeUser( users );
    return users;
}