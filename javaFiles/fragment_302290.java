String serverVersion = DatamodelVersion.getInstance().getVersion();
String[] version = serverVersion.split("\\.");
if (Integer.parseInt(version[0]) > 11 || (Integer.parseInt(version[0]) == 11 && Integer.parseInt(version[1]) >= 3))
{
    outstr = new FileOutputStream(confFile);
    prop.setProperty("NTFSDriver", "11.3.0/x86/tntfs.ko");
    prop.setProperty("NTFSDriver_x64", "11.3.0/x86_64/tntfs.ko");

    prop.store(outstr, "");

    update = true;
    System.out.println("Updated the tuxera conf file successfully");
    logger.logDebugAlways("Updated the tuxera conf file successfully");
}